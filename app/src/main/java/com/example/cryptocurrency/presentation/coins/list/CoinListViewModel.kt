package com.example.cryptocurrency.presentation.coins.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.coins.GetCoinsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsListUseCase: GetCoinsListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinsListStatus())
    val state: State<CoinsListStatus> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsListUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinsListStatus(error = result.message ?: "Undefined error !!")
                }
                is Resource.Loading -> {
                    _state.value = CoinsListStatus(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinsListStatus(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}