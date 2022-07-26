package com.example.cryptocurrency.data.coins

import com.example.cryptocurrency.data.coins.dto.CoinDetailDto
import com.example.cryptocurrency.data.coins.dto.CoinDto
import com.example.cryptocurrency.domain.coins.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }

    override suspend fun getCoinList(): List<CoinDto> {
        return api.getCoinsLis()
    }
}