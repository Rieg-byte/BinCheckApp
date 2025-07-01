package com.rieg.binapp.data.mappers

import com.rieg.binapp.data.local.entities.CardInfoEntity
import com.rieg.binapp.data.model.CardInfoResponse
import com.rieg.binapp.domain.model.BankInfo
import com.rieg.binapp.domain.model.CardInfo
import com.rieg.binapp.domain.model.CountryInfo

fun CardInfoResponse.toCardInfo(bin: String): CardInfo {
    val countryInfo = CountryInfo(
        name = country?.name,
        latitude = country?.latitude,
        longitude = country?.longitude
    )
    val bankInfo = BankInfo(
        name = bank?.name,
        url = bank?.url,
        phone = bank?.phone,
        city = bank?.city
    )
    return CardInfo(
        bin = bin,
        cardType = type,
        scheme = scheme,
        brand = brand,
        countryInfo = countryInfo,
        bankInfo = bankInfo
    )
}

fun CardInfoEntity.toCardInfo(): CardInfo {
    val countryInfo = CountryInfo(
        name = country,
        latitude = latitude,
        longitude = longitude
    )
    val bankInfo = BankInfo(
        name = bankName,
        url = bankUrl,
        phone = bankPhone,
        city = bankCity
    )
    return CardInfo(
        bin = bin,
        cardType = cardType,
        scheme = scheme,
        brand = brand,
        countryInfo = countryInfo,
        bankInfo = bankInfo
    )
}

fun CardInfo.toCardInfoEntity(bin: String): CardInfoEntity {
    return CardInfoEntity(
        bin = bin,
        cardType = cardType,
        scheme = scheme,
        brand = brand,
        country = countryInfo.name,
        latitude = countryInfo.latitude,
        longitude = countryInfo.longitude,
        bankName = bankInfo.name,
        bankUrl = bankInfo.url,
        bankPhone = bankInfo.phone,
        bankCity = bankInfo.city
    )
}