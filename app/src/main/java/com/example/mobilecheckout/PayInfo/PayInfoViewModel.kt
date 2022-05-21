package com.example.mobilecheckout.PayInfo

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilecheckout.PayInfo.IPayInfoRepo
import com.example.mobilecheckout.PayInfo.PayInfo
import com.example.mobilecheckout.PayInfo.PayInfoDatabaseRepo
import kotlinx.coroutines.launch


class PayInfoViewModel(app: Application) : AndroidViewModel(app) {
    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    private val _cardNum: MutableState<String> = mutableStateOf("")
    val cardNum: State<String> = _cardNum

    private val _track: MutableState<String> = mutableStateOf("")
    val cvv: State<String> = _track

    private val _expMonth: MutableState<String> = mutableStateOf("")
    val expMonth: State<String> = _expMonth

    private val _expYear: MutableState<String> = mutableStateOf("")
    val expYear: State<String> = _expYear

    private val _billingAddress: MutableState<String> = mutableStateOf("")
    val billingAddress: State<String> = _billingAddress

    private val _zipCode: MutableState<String> = mutableStateOf("")
    val zipCode: State<String> = _zipCode

    private val _repository: PayInfoDatabaseRepo = PayInfoDatabaseRepo(app)
    private val _payment: MutableState<List<PayInfo>> = mutableStateOf(listOf())

    fun setName(name: String) { _name.value = name }
    fun setCardNum(cardNum: String) { _cardNum.value = cardNum }
    fun setCVV(cvv: String) { _track.value = cvv }
    fun setExpMonth(expMonth: String) { _expMonth.value = expMonth }
    fun setExpYear(expYear: String) { _expYear.value = expYear }
    fun setBillingAddress(billingAddress: String) { _billingAddress.value = billingAddress }
    fun setZipCode(zipCode: String) { _zipCode.value = zipCode }

    fun addPayInfo(payinfo: PayInfo) {
        viewModelScope.launch {
            _repository.addPayInfo(payinfo)
            _payment.value = _repository.getPayInfo()
        }
    }

    fun save(): PayInfo {
        return PayInfo(0, name.value, cardNum.value, cvv.value, expMonth.value, expYear.value, billingAddress.value, zipCode.value)
    }
}