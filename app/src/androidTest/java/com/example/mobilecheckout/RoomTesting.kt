package com.example.mobilecheckout

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.mobilecheckout.PH.PHDao
import com.example.mobilecheckout.PH.PHDatabase
import com.example.mobilecheckout.PH.PHModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RoomTesting {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var phDatabase: PHDatabase
    private lateinit var phDao: PHDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        phDatabase = Room.inMemoryDatabaseBuilder(context, PHDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        phDao = phDatabase.phDao()
    }
    @After
    fun teardown() {
        phDatabase.close()
    }
    @Test
    fun insertPH() = runBlocking {
        val phEntity = PHModel("03/08/2000", 1, 20.99, "Big Hat", "nah", "test")
        phDao.addPHistory(phEntity)
        val phEntitys= phDao.getPHistory()
        assert(phEntitys.contains(phEntity))

    }
    @Test
    fun deletePH() = runBlocking {
        val phEntity = PHModel("03/08/2000", 1, 20.99, "Small Hat", "nah", "test")
        phDao.addPHistory(phEntity)
        phDao.deletePHistory(phEntity)
        val phEntitys= phDao.getPHistory()
        if(phEntitys.contains(phEntity)) {
            var BooTest = false
            assert(BooTest)
        } else {
            var BooTest = true
            assert(BooTest)
        }
    }
    @Test
    fun updatePH() = runBlocking {
        val phEntity = PHModel("03/08/2000", 1, 20.99, "Big Hat", "nah", "test")
        phDao.addPHistory(phEntity)
        val NewPH = phEntity.copy(date = "04/12/2001")
        phDao.updatePHistory(NewPH)
        val phEntitys= phDao.getPHistory()
        assert(phEntitys.contains(NewPH))
        //phEntitys.contains(phEntity)).isTrue()
    }
}