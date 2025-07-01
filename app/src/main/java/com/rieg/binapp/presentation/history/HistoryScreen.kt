package com.rieg.binapp.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rieg.binapp.R
import com.rieg.binapp.domain.model.BankInfo
import com.rieg.binapp.domain.model.CardInfo
import com.rieg.binapp.domain.model.CountryInfo
import com.rieg.binapp.ui.components.cards.BinInfoCard
import com.rieg.binapp.ui.theme.BinAppTheme

@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    val historyUiState by historyViewModel.historyUiState.collectAsState()
    HistoryScreen(
        listOfCardInfo = historyUiState.listOfCardInfo,
        onNavigateBack = onNavigateBack
    )
}


@Composable
private fun HistoryScreen(
    listOfCardInfo: List<CardInfo>,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            HistoryTopBar(onBack = onNavigateBack)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (listOfCardInfo.isEmpty()) {
                NoHistoryScreen()
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(listOfCardInfo) { cardInfo ->
                        BinInfoCard(cardInfo = cardInfo)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryTopBar(
    onBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.query_history))
        },
        navigationIcon = {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                    )
            }
        }
    )
}

@Composable
fun NoHistoryScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(stringResource(R.string.no_history))
    }
}

@Preview(showBackground = true)
@Composable
fun NoHistoryScreenPreview() {
    BinAppTheme {
        NoHistoryScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryTopBarPreview() {
    BinAppTheme {
        HistoryTopBar(
            onBack = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun HistoryScreenPreview() {
    val countryInfo = CountryInfo(
        name = "Дания",
        latitude = 56,
        longitude = 10
    )
    val bankInfo = BankInfo(
        name = "ПСБ",
        city = null,
        url = "https://www.psbank.ru/",
        phone = null
    )
    BinAppTheme {
        HistoryScreen(
            listOfCardInfo = listOf<CardInfo>(
                CardInfo(
                    cardType = "Credit",
                    scheme = "Visa",
                    brand = "Visa/Dankort",
                    countryInfo = countryInfo,
                    bankInfo = bankInfo,
                    bin = "49394932"
                )
            ),
            onNavigateBack = {}
        )
    }
}