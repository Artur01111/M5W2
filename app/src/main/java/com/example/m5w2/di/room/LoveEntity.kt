package com.example.m5w2.di.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "love_table")
data class LoveEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = DEFAULT_ID,
    @ColumnInfo("first_name")
    val firstName: String,
    @ColumnInfo("second_name")
    val secondName: String,
    val percentage: String,
    val result: String
) {
    companion object{
        const val DEFAULT_ID = 0
    }
}