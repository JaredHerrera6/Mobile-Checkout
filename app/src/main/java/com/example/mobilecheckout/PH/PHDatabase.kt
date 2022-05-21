package com.example.mobilecheckout.PH

import androidx.room.*
//Interface for my database that I use for Testing later also
@Dao
interface PHDao {

    @Query("select * from phmodel ")
    suspend fun getPHistory(): List<PHModel>

    @Query("select * from phmodel ")
    suspend fun getPHistoryOnline(): List<PHModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPHistory(purchase: PHModel)

    @Delete
    suspend fun deletePHistory(purchase: PHModel)

    @Update
    suspend fun updatePHistory(purchase: PHModel)
}

@Database(entities = [PHModel::class], version = 4, exportSchema = false)
abstract class PHDatabase :RoomDatabase() {
    abstract fun phDao(): PHDao

}
