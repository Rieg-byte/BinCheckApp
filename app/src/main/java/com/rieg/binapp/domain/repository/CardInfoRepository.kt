package com.rieg.binapp.domain.repository

import com.rieg.binapp.domain.model.CardInfo

interface CardInfoRepository {
    suspend fun getCardInfo(bin: String): CardInfo
    suspend fun getCardInfoHistory(): List<CardInfo>
}