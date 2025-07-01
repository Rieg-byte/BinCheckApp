package com.rieg.binapp.data.repository

import com.rieg.binapp.data.local.CardInfoDao
import com.rieg.binapp.data.mappers.toCardInfo
import com.rieg.binapp.data.mappers.toCardInfoEntity
import com.rieg.binapp.data.remote.BinListApiService
import com.rieg.binapp.domain.model.CardInfo
import com.rieg.binapp.domain.repository.CardInfoRepository
import javax.inject.Inject

class CardInfoRepositoryImpl @Inject constructor(
    private val binListApiService: BinListApiService,
    private val cardInfoDao: CardInfoDao
): CardInfoRepository {
    override suspend fun getCardInfo(bin: String): CardInfo {
        val cardInfo = binListApiService.getCardInfo(bin).toCardInfo(bin)
        cardInfoDao.insert(cardInfo.toCardInfoEntity(bin))
        return cardInfo
    }

    override suspend fun getCardInfoHistory(): List<CardInfo> =
        cardInfoDao.getAll().map { it.toCardInfo() }
}