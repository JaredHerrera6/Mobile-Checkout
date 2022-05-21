package com.example.mobilecheckout.PH

import androidx.room.Entity
import androidx.room.PrimaryKey

//how i structured my json data in my database
@Entity
data class PHModel (
    val date: String,
    @PrimaryKey
    val purchaseId: Int,
    val purchaseAmount: Double,
    val itemName: String,
    val itemDes: String,
    val itemPic: String



)