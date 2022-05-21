package com.example.mobilecheckout.PayInfo

import android.app.Application
import androidx.room.Room

class PayInfoDatabaseRepo(
    app: Application,
) : PayInfoDao {
    private val db: PayInfoDatabase = Room.databaseBuilder(
        app,
        PayInfoDatabase::class.java,
        "payInfo.db"
    ).fallbackToDestructiveMigration().build()

    override suspend fun getPayInfo(): List<PayInfo> {
        return db.payinfoDao().getPayInfo()
    }

    override suspend fun addPayInfo(payinfo: PayInfo) {
        db.payinfoDao().addPayInfo(payinfo)
    }

    override fun getID(): Int {
        return db.payinfoDao().getID()
    }

    override fun getName(): String { return db.payinfoDao().getName() }

    override fun getCardNum(): String { return db.payinfoDao().getCardNum() }

    override fun getCVV(): String { return db.payinfoDao().getCVV() }

    override fun getExpMonth(): String { return db.payinfoDao().getExpMonth() }

    override fun getExpYear(): String { return db.payinfoDao().getExpYear() }

    override fun getBillingAddress(): String { return db.payinfoDao().getBillingAddress() }

    override fun getZipCode(): String { return db.payinfoDao().getZipCode() }
}
