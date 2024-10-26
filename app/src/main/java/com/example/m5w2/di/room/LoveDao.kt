package com.example.m5w2.di.room

import android.health.connect.datatypes.units.Percentage
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LoveDao {

    @Insert(onConflict = 1)
    fun insertHistory(loveEntity: LoveEntity)

    @Query("SELECT * FROM love_table")
    fun getAllHistory(): List<LoveEntity>

    @Delete
    fun deleteHistory(loveEntity: LoveEntity)

    @Query("DELETE FROM love_table")
    fun deleteAllHistory()

    @Update
    fun updateHistory(loveEntity: LoveEntity)

    @Query("DELETE FROM love_table WHERE id IN (:ids)")
    fun deleteHistoryById(ids:List<Int>)

    @Query("SELECT * FROM  love_table ORDER BY first_name ASC")
    fun getDescendingHistory(): List<LoveEntity>

    @Query("SELECT * FROM  love_table ORDER BY id DESC")
    fun getDescendingHistoryById(): List<LoveEntity>

    @Query("SELECT * FROM  love_table WHERE percentage > :min OR percentage < :max")
    fun getHistoryWherePercentageIsGreaterThan(min: String, max:String): List<LoveEntity>
}