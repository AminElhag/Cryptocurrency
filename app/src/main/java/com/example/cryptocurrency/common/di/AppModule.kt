package com.example.cryptocurrency.common.di

import com.example.cryptocurrency.common.Constants
import com.example.cryptocurrency.data.coins.CoinPaprikaApi
import com.example.cryptocurrency.data.coins.CoinRepositoryImp
import com.example.cryptocurrency.domain.coins.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImp(api)
    }

    @Singleton
    @Provides
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}