package com.rieg.binapp.domain.model

data class CardInfo(
    val bin: String,
    val cardType: String?,
    val scheme: String?,
    val brand: String?,
    val countryInfo: CountryInfo,
    val bankInfo: BankInfo
)
