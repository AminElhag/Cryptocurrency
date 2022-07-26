package com.example.cryptocurrency.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrency.presentation.coins.CoinsScreen
import com.example.cryptocurrency.presentation.coins.details.components.CoinsDetailScreen
import com.example.cryptocurrency.presentation.coins.list.components.CoinsListScreen
import com.example.cryptocurrency.presentation.main.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = CoinsScreen.CoinListScreen.route,
                    ) {
                        composable(CoinsScreen.CoinListScreen.route) {
                            CoinsListScreen(navController = navController)
                        }
                        composable(CoinsScreen.CoinDetailScreen.route + "/{coinId}") {
                            CoinsDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

