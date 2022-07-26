package com.example.cryptocurrency.presentation.coins.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Constants
import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.coins.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailStatus())
    val state: State<CoinDetailStatus> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAMETER_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinDetailStatus(error = result.message ?: "Undefined error !!")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailStatus(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailStatus(coin = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}