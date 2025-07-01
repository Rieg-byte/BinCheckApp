package com.rieg.binapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cards")
data class CardInfoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "bin")
    val bin: String,
    @ColumnInfo(name = "card_type")
    val cardType: String?,
    @ColumnInfo(name = "scheme")
    val scheme: String?,
    @ColumnInfo(name = "brand")
    val brand: String?,
    @ColumnInfo(name = "country")
    val country: String?,
    @ColumnInfo(name = "latitude")
    val latitude: Int?,
    @ColumnInfo(name = "longitude")
    val longitude: Int?,
    @ColumnInfo(name = "bank_name")
    val bankName: String?,
    @ColumnInfo(name = "bank_url")
    val bankUrl: String?,
    @ColumnInfo(name = "bank_phone")
    val bankPhone: String?,
    @ColumnInfo(name = "bank_city")
    val bankCity: String?
)

