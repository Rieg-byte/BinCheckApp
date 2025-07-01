package com.rieg.binapp.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rieg.binapp.domain.repository.CardInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val cardInfoRepository: CardInfoRepository
): ViewModel() {

    private val _historyUiState = MutableStateFlow(HistoryUiState())
    val historyUiState: StateFlow<HistoryUiState> = _historyUiState.asStateFlow()

    init {
        getHistory()
    }

    fun getHistory() = viewModelScope.launch {
        val listOfCardInfo = cardInfoRepository.getCardInfoHistory()
        _historyUiState.update {
            it.copy(
                listOfCardInfo = listOfCardInfo
            )
        }
    }
}