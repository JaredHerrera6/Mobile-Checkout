package com.example.mobilecheckout.PayInfo


import androidx.compose.runtime.State
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "payment_info")
class PayInfo {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "CardNum")
    var cardNum: String = ""
    @ColumnInfo(name = "cvv")
    var cvv: String = ""
    @ColumnInfo(name = "expMonth")
    var expMonth: String = ""
    @ColumnInfo(name = "expYear")
    var expYear: String = ""
    @ColumnInfo(name = "billingAddress")
    var billingAddress: String = ""
    @ColumnInfo(name = "zipCode")
    var zipCode: String = ""

    constructor(
        id: Int,
        name: String,
        cardNum: String,
        cvv: String,
        expMonth: String,
        expYear: String,
        billingAddress: String,
        zipCode: String
    ){
        this.id= id
        this.name = name
        this.cardNum = cardNum
        this.cvv = cvv
        this.expMonth = expMonth
        this.expYear = expYear
        this.billingAddress = billingAddress
        this.zipCode = zipCode
    }
}