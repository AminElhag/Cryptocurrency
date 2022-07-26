package com.example.cryptocurrency.data.coins

import com.example.cryptocurrency.data.coins.dto.CoinDetailDto
import com.example.cryptocurrency.data.coins.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoinsLis(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}