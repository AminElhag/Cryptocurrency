package com.example.cryptocurrency.presentation.coins.list

import com.example.cryptocurrency.domain.coins.models.Coin

data class CoinsListStatus(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)