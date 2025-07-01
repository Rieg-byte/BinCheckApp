package com.rieg.binapp.presentation.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rieg.binapp.domain.repository.CardInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val cardInfoRepository: CardInfoRepository
): ViewModel() {
    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState.Default)
    val mainUiState = _mainUiState.asStateFlow()

    var bin: String by mutableStateOf("")
        private set

    fun updateBin(newBin: String) {
        bin = newBin
    }


    fun getCardInfo(bin: String) = viewModelScope.launch {
        try {
            _mainUiState.value = MainUiState.Loading
            val cardInfo = cardInfoRepository.getCardInfo(bin)
            _mainUiState.value = MainUiState.Success(cardInfo = cardInfo)
        } catch (e: Exception) {
            _mainUiState.value = MainUiState.Error
        }
    }
}