package com.rieg.binapp.di

import android.content.Context
import androidx.room.Room
import com.rieg.binapp.data.local.AppDatabase
import com.rieg.binapp.data.local.CardInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideCardInfoDao(appDatabase: AppDatabase): CardInfoDao {
        return appDatabase.cardInfoDao()
    }
}