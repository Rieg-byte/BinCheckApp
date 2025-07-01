package com.rieg.binapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rieg.binapp.data.local.entities.CardInfoEntity

@Dao
interface CardInfoDao {
    @Insert
    suspend fun insert(cardInfoEntity: CardInfoEntity)

    @Query("SELECT * FROM cards")
    suspend fun getAll(): List<CardInfoEntity>
}