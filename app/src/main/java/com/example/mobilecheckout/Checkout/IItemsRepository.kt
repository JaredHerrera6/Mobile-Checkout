package com.example.mobilecheckout.Checkout
//Interface used to get the functions that we want to implement for
//Our repository
interface IItemsRepository {
    suspend fun getItems():List<Item>
    suspend fun deleteItem(idx:Int)
    suspend fun AddItem(item:Item)
    suspend fun DeleteAll():List<Item>
}
