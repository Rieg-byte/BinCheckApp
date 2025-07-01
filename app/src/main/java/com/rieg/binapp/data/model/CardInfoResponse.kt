package com.rieg.binapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CardInfoResponse(
    val number: NumberInfoResponse? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: CountryInfoResponse? = null,
    val bank: BankInfoResponse? = null
) {
    @Serializable
    data class NumberInfoResponse(
        val length: Int? = null,
        val luhn: Boolean? = null
    )

    @Serializable
    data class CountryInfoResponse(
        val numeric: String? = null,
        val alpha2: String? = null,
        val name: String? = null,
        val emoji: String? = null,
        val currency: String? = null,
        val latitude: Int? = null,
        val longitude: Int? = null
    )

    @Serializable
    data class BankInfoResponse(
        val name: String? = null,
        val url: String? = null,
        val phone: String? = null,
        val city: String? = null
    )
}