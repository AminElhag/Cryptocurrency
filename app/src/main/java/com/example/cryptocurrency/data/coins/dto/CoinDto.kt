package com.example.cryptocurrency.data.coins.dto

import com.example.cryptocurrency.domain.coins.models.Coin
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoinDto(
    val id: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) : Serializable

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type,
    )
}