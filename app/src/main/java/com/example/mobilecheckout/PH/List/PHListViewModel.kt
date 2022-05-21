package com.example.mobilecheckout.PH.List

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilecheckout.PH.*
import kotlinx.coroutines.launch

class PHListViewModel (app:Application): AndroidViewModel(app) {
    private val _purchases: MutableState<List<PHModel>> = mutableStateOf(listOf())
    val purchases: State<List<PHModel>> = _purchases

    private val PhRepo: PHDao = PhAPI(
        PHDatabase = PHDatabaseRepo(app),
        PHFetch = PHOnline()
    )
//First launch is called when the app starts no matter what, second one is only called when there is internet connection
    init {
        viewModelScope.launch {
            _purchases.value = PhRepo.getPHistory()
        }
        val connect = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connect.requestNetwork(network, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                viewModelScope.launch {
                    _purchases.value = PhRepo.getPHistoryOnline()
                }
            }
        })

    }


}