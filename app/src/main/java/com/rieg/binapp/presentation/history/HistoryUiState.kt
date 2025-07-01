package com.rieg.binapp.presentation.history

import com.rieg.binapp.domain.model.CardInfo

data class HistoryUiState(
    val listOfCardInfo: List<CardInfo> = emptyList<CardInfo>()
)
