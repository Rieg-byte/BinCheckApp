package com.rieg.binapp.ui.components.fields

import androidx.compose.ui.text.input.OffsetMapping

class BinOffsetMapping: OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset <= 4 -> offset
            else -> offset + 1
        }
    }

    override fun transformedToOriginal(offset: Int): Int {
        return when {
            offset <= 4 -> offset
            else -> offset - 1
        }
    }
}