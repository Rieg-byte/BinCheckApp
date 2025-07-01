package com.rieg.binapp.ui.components.fields

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class BinVisualTransformation: VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val input = text.text
        val formatted = StringBuilder()
        for (i in input.indices) {
            if (i == 4) {
                formatted.append(' ')
            }
            formatted.append(input[i])
        }
        return TransformedText(
            text = AnnotatedString(text = formatted.toString()),
            offsetMapping = BinOffsetMapping()
        )
    }
}