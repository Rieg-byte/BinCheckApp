package com.rieg.binapp.ui.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rieg.binapp.R
import com.rieg.binapp.ui.theme.BinAppTheme

@Composable
fun BinField(
    bin: String,
    onBinChange: (String) -> Unit,
    isError: Boolean = false,
    supportingText:  @Composable() (() -> Unit)? = null
) {
    val maxBinLength = 8
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = bin,
        onValueChange = { newValue ->
            if (newValue.length <= maxBinLength) {
                onBinChange(newValue)
            }
        },
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(stringResource(R.string.placeholder_bincode))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        label = {
            Text(stringResource(R.string.bincode_input))
        },
        visualTransformation = BinVisualTransformation(),
        isError = isError,
        supportingText = supportingText
    )
}

@Preview(showBackground = true)
@Composable
fun BinCodeFieldPreview() {
    BinAppTheme {
        BinField(
            bin = "",
            onBinChange = {}
        )
    }
}