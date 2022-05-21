package com.example.mobilecheckout.Checkout

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SongListVM : ViewModel() {
    private val _items: MutableState<List<Item>> = mutableStateOf(listOf())
    val items: State<List<Item>> = _items
    private val _repository: IItemsRepository = ItemsRepository()

    init {
        viewModelScope.launch {
            _items.value = _repository.getItems()
        }
    }
    fun addItem(item:Item){
        viewModelScope.launch {
            _repository.AddItem(item)
            _items.value = _repository.getItems()
        }
    }
    fun deleteItem(idx:Int){
        viewModelScope.launch {
            deleteItemAsync(idx)
        }
    }
    suspend fun deleteItemAsync(idx: Int) {
        val deleteJob = viewModelScope.async { _repository.deleteItem(idx) }
        deleteJob.await()
        _items.value = _repository.getItems()
    }
}