package com.example.mobilecheckout

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mobilecheckout.Checkout.Item

class AddItemViewModel: ViewModel(){
    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name
    private val _price: MutableState<String> = mutableStateOf("")
    val price : State<String> = _price
    private val _brand: MutableState<String> = mutableStateOf((""))
    val brand:State<String> = _brand
    //Sets the new item name
    fun setName(name:String){
        _name.value =  name
    }
    //Sets the new item Price
    fun setPrice(price:String){
        _price.value = price
    }
    //Sets the new item Brand name
    fun setBrand(brand:String){
        _brand.value = brand
    }
    //Validates the Input Fields from the Add item screen
    //If either field is left blank, A msg will be return telling
    // The user to enter a value to the indicated Text field
    fun validate(): Item {
        if(name.value.isEmpty()) {
            throw Exception("Enter Your item Name")
        }
        if(price.value.isEmpty()) {
            throw Exception("Please Enter a Price")
        }
        if(brand.value.isEmpty()) {
            throw Exception("Enter a Brand")
        }
        //Upon the values becoming validated
        //The item is returned to the function so that is can be added
        //to the list
        return Item(name.value, price.value, brand.value)
    }
}