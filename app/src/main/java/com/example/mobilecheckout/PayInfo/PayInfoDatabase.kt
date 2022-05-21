package com.example.mobilecheckout.PayInfo

import androidx.room.*

@Dao
interface PayInfoDao {

    @Query("Select id from payment_info")
    fun getID(): Int

    @Query("Select name from payment_info")
    fun getName(): String

    @Query("Select CardNum from payment_info")
    fun getCardNum(): String

    @Query("Select cvv from payment_info")
    fun getCVV(): String

    @Query("Select expMonth from payment_info")
    fun getExpMonth(): String

    @Query("Select expYear from payment_info")
    fun getExpYear(): String

    @Query("Select billingAddress from payment_info")
    fun getBillingAddress(): String

    @Query("Select zipCode from payment_info")
    fun getZipCode(): String

    @Query("Select * from payment_info")
    suspend fun getPayInfo(): List<PayInfo>

    @Insert
    suspend fun addPayInfo(payinfo: PayInfo)
}

@Database(entities = [PayInfo::class], version = 1, exportSchema = false)
abstract class PayInfoDatabase : RoomDatabase() {
    abstract fun payinfoDao(): PayInfoDao
}

