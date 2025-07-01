package com.rieg.binapp.di

import com.rieg.binapp.data.repository.CardInfoRepositoryImpl
import com.rieg.binapp.domain.repository.CardInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideCurrencyRepository(
        cardInfoRepository: CardInfoRepositoryImpl
    ): CardInfoRepository
}