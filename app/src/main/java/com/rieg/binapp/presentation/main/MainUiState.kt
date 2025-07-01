package com.rieg.binapp.presentation.main

import com.rieg.binapp.domain.model.CardInfo



sealed interface MainUiState {
    data class Success(
        val cardInfo: CardInfo
    ): MainUiState
    object Loading: MainUiState
    object Error: MainUiState
    object Default: MainUiState
}