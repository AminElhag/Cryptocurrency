package com.example.cryptocurrency.presentation.coins

sealed class CoinsScreen(val route: String) {
    object CoinListScreen : CoinsScreen("coin_list_screen")
    object CoinDetailScreen : CoinsScreen("coin_detail_screen")
}
