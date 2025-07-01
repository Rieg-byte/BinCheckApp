package com.rieg.binapp.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rieg.binapp.R
import com.rieg.binapp.domain.model.BankInfo
import com.rieg.binapp.domain.model.CardInfo
import com.rieg.binapp.domain.model.CountryInfo
import com.rieg.binapp.ui.theme.BinAppTheme


@Composable
fun BinInfoCard(
    cardInfo: CardInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CardInfoSection(
                label = stringResource(R.string.bin),
                text = cardInfo.bin,
            )
            HorizontalDivider()
            CardInfoSection(
                label = stringResource(R.string.network),
                text = cardInfo.scheme ?: "",
            )
            HorizontalDivider()
            CardInfoSection(
                label = stringResource(R.string.brand),
                text = cardInfo.brand ?: "",
            )
            HorizontalDivider()
            CardInfoSection(
                label = stringResource(R.string.type),
                text = cardInfo.cardType ?: "",
            )
            HorizontalDivider()
            CardInfoSection(
                label = stringResource(R.string.network),
                text = cardInfo.scheme ?: "",
            )
            HorizontalDivider()
            BankInfoSection(
                bankName = cardInfo.bankInfo.name ?: "",
                city = cardInfo.bankInfo.city ?: "",
                url = cardInfo.bankInfo.url ?: "",
                phone = cardInfo.bankInfo.phone ?: ""
            )
            HorizontalDivider()
            CountryInfoSection(
                name = cardInfo.countryInfo.name ?: "",
                latitude = cardInfo.countryInfo.latitude ?: 0,
                longitude = cardInfo.countryInfo.longitude ?: 0
            )
        }
    }
}

@Composable
fun CardInfoSection(
    label: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CountryInfoSection(
    name: String,
    latitude: Int,
    longitude: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.country),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                append(stringResource(R.string.longitude))
                append(": ")
                pop()
                append("$longitude")
            },
            fontSize = 10.sp
        )
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                append(stringResource(R.string.latitude))
                append(": ")
                pop()
                append("$latitude")
            },
            fontSize = 10.sp
        )
    }
}


@Composable
fun BankInfoSection(
    bankName: String,
    city: String,
    url: String,
    phone: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(R.string.bank),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )
        Text(
            text = bankName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Column {
            Text(
                text = buildAnnotatedString {
                    pushStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                    append(stringResource(R.string.city))
                    append(": ")
                    pop()
                    append(city)
                },
                fontSize = 10.sp
            )
            Text(
                text = buildAnnotatedString {
                    pushStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                    append(stringResource(R.string.url))
                    append(": ")
                    pop()
                    append(url)
                },
                fontSize = 10.sp
            )
            Text(
                text = buildAnnotatedString {
                    pushStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
                    append(stringResource(R.string.phone))
                    append(": ")
                    pop()
                    append(phone)
                },
                fontSize = 10.sp
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun CardInfoSectionPreview() {
    BinAppTheme {
        CardInfoSection(
            label = "Платёжная система",
            text = "MIR"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CountryInfoSectionPreview() {
    BinAppTheme {
        CountryInfoSection(
            name = "Дания",
            latitude = 56,
            longitude = 10
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BankInfoSectionPreview() {
    BinAppTheme {
        BankInfoSection(
            bankName = "ПСБ",
            city = "Ярославль",
            url = "https://www.psbank.ru/",
            phone = "8 800 333 03 03"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BinInfoCardPreview() {
    val countryInfo = CountryInfo(
        name = "Дания",
        latitude = 56,
        longitude = 10
    )
    val bankInfo = BankInfo(
        name = "ПСБ",
        city = "Ярославль",
        url = "https://www.psbank.ru/",
        phone = "8 800 333 03 03"
    )
    BinAppTheme {
        BinInfoCard(
            cardInfo = CardInfo(
                cardType = "Credit",
                scheme = "Visa",
                brand = "Visa/Dankort",
                countryInfo = countryInfo,
                bankInfo = bankInfo,
                bin = "32942439"
            ),
        )
    }
}