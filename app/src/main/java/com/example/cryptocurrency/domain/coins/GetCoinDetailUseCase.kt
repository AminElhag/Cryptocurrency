package com.example.cryptocurrency.domain.coins

import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.data.coins.dto.toCoinDetail
import com.example.cryptocurrency.domain.coins.models.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            when (e) {
                is IOException -> {
                    emit(Resource.Error("Time out"))
                }
                is HttpException -> {
                    emit(Resource.Error(message = e.localizedMessage))
                }
                else -> {
                    emit(Resource.Error("Unknown exception"))
                }
            }
        }
    }
}