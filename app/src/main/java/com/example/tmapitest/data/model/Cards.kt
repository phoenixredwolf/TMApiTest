package com.example.tmapitest.data.model

import com.example.tmapitest.util.CardType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cards(
    val card: Card,
    @Json(name = "card_type")
    val cardType: CardType
)
