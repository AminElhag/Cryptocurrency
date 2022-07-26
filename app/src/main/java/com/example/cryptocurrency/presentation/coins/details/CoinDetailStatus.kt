package com.example.cryptocurrency.presentation.coins.details

import com.example.cryptocurrency.domain.coins.models.CoinDetail

data class CoinDetailStatus(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)