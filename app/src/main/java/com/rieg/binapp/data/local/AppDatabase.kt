package com.rieg.binapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rieg.binapp.data.local.entities.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 4)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardInfoDao(): CardInfoDao
}