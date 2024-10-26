package com.example.m5w2.di.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoveEntity::class], version = 1)
abstract class LoveDataBase: RoomDatabase(){
    abstract fun loveDao(): LoveDao
}