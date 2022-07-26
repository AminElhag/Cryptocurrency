package com.example.cryptocurrency.domain.coins.models

import java.io.Serializable

data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) : Serializable