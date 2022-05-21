package com.example.mobilecheckout.PH

class PhAPI (
    private val PHDatabase: PHDatabaseRepo,
    private val PHFetch: IPHOnline,


    ) :PHDao {
    //Only activates when the phone is connected to internet then puts the list into the database
    override suspend fun getPHistoryOnline(): List<PHModel> {

        val purchases = PHFetch.onlinePH()
        purchases.forEach{
                purchase ->
            PHDatabase.addPHistory(purchase)
        }
        return PHDatabase.getPHistory()
    }
// just calls the list stored in the database
    override suspend fun getPHistory(): List<PHModel> {


        return PHDatabase.getPHistory()
    }

    override suspend fun addPHistory(purchase: PHModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePHistory(purchase: PHModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePHistory(purchase: PHModel) {
        TODO("Not yet implemented")
    }


}