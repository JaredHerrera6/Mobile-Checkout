package com.example.mobilecheckout.PayInfo

interface IPayInfoRepo {
    suspend fun getPayInfo(): List<PayInfo>
    suspend fun addPayInfo(payinfo: PayInfo)
}

