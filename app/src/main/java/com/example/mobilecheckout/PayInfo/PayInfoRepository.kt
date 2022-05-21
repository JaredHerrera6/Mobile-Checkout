package com.example.mobilecheckout.PayInfo

class PayInfoRepository : IPayInfoRepo {

    private var _payinfo = listOf<PayInfo>()

    init {
        _payinfo = (0..1).map { i ->
            PayInfo(
                i,
                "$i",
                "$i",
                "$i",
                "$i",
                "$i",
                "$i",
                "$i"
            )
        }
    }

    override suspend fun getPayInfo(): List<PayInfo> {
        return _payinfo
    }

    override suspend fun addPayInfo(payinfo: PayInfo) {
        _payinfo = listOf(payinfo) + _payinfo
    }
}