package com.rieg.binapp.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rieg.binapp.R
import com.rieg.binapp.ui.components.cards.BinInfoCard
import com.rieg.binapp.ui.components.fields.BinField
import com.rieg.binapp.ui.theme.BinAppTheme


@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navigateToHistory: () -> Unit
) {
    val mainUiState by mainViewModel.mainUiState.collectAsState()
    MainScreen(
        bin = mainViewModel.bin,
        onBinChange = mainViewModel::updateBin,
        onSearch = { mainViewModel.getCardInfo(mainViewModel.bin) },
        navigateToHistory = navigateToHistory,
        mainUiState = mainUiState
    )
}
@Composable
private fun MainScreen(
    bin: String,
    onBinChange: (String) -> Unit,
    onSearch: () -> Unit,
    navigateToHistory: () -> Unit,
    mainUiState: MainUiState
) {
    var isError by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BinField(
                    bin= bin,
                    onBinChange = onBinChange,
                    isError = isError,
                    supportingText = {
                        if (isError) {
                            Text(stringResource(R.string.error_bin))
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        if (bin.length < 6) {
                            isError = true
                        } else {
                            onSearch()
                            isError = false
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(stringResource(R.string.search))
                }
                HorizontalDivider()
                HistoryButton(
                    onClick = navigateToHistory
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        MainBody(mainUiState)
    }
}

@Composable
fun MainBody(
    mainUiState: MainUiState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when(mainUiState) {
            MainUiState.Default -> {}
            MainUiState.Error -> ErrorScreen()
            MainUiState.Loading -> LoadingScreen()
            is MainUiState.Success -> BinInfoCard(
                cardInfo = mainUiState.cardInfo,
                modifier = Modifier.verticalScroll(state = rememberScrollState())
            )
        }
    }
}

@Composable
fun ErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(stringResource(R.string.error_text))
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun HistoryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(stringResource(R.string.query_history))
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryButtonPreview() {
    BinAppTheme {
        HistoryButton(
            onClick = {}
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    BinAppTheme {
        MainScreen(
            bin = "",
            onBinChange = {},
            onSearch = {},
            navigateToHistory = {},
            mainUiState = MainUiState.Loading
        )
    }
}