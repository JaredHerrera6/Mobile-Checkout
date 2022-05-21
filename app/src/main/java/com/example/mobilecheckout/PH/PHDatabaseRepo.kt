package com.example.mobilecheckout.PH

import android.app.Application
import androidx.room.Room

class PHDatabaseRepo(app: Application) : PHDao {
//Repo for my database
    private val db: PHDatabase = Room.databaseBuilder(
        app,
        PHDatabase::class.java,
        "PHistory.db"
    ).fallbackToDestructiveMigration().build()

    override suspend fun getPHistory(): List<PHModel> {
        return db.phDao().getPHistory()
    }

    override suspend fun getPHistoryOnline(): List<PHModel> {
        return db.phDao().getPHistory()
    }

    override suspend fun addPHistory(purchase: PHModel) {
        return db.phDao().addPHistory(purchase)
    }

    override suspend fun deletePHistory(purchase: PHModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePHistory(purchase: PHModel) {
        TODO("Not yet implemented")
    }
}