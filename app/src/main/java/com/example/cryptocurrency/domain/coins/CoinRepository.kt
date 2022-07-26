package com.example.cryptocurrency.domain.coins

import com.example.cryptocurrency.data.coins.dto.CoinDetailDto
import com.example.cryptocurrency.data.coins.dto.CoinDto

interface CoinRepository {
    suspend fun getCoinById(coinId: String): CoinDetailDto
    suspend fun getCoinList(): List<CoinDto>
}