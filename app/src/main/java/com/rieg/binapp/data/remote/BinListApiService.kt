package com.rieg.binapp.data.remote

import com.rieg.binapp.data.model.CardInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApiService {
    @GET("{bin}")
    suspend fun getCardInfo(@Path("bin") bin: String): CardInfoResponse
}