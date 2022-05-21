package com.example.mobilecheckout.Checkout

import kotlinx.coroutines.delay

class ItemsRepository : IItemsRepository {
    //Items List
    private var _items =  listOf<Item>()
//Initialized 12 items
    init {
        _items = (0..12).map { i ->
            Item("Cereal", "5.55", "Kellogs")
        }
    }
    //Returns the Items
    override suspend fun getItems(): List<Item> {
        return _items
    }
    //Deletes the Item at the given index
    override suspend fun deleteItem(idx: Int) {
        _items = _items.subList(0, idx) + _items.subList(idx+1, _items.size)
    }
    //Adds the item passed to the List
    override suspend fun AddItem(item: Item) {
        _items = listOf(item) + _items
    }
    //Unable to implement List
    override suspend fun DeleteAll(): List<Item> {
        TODO("Not yet implemented")
    }

}