package com.example.tmapitest.data.model.utility

import com.example.tmapitest.util.CardType
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

// Adapter to determine card type
object CardTypeAdapter {

    @ToJson
    fun toJson(card: CardType) = card.name

    @FromJson
    fun fromJson(cardType: String) = when (cardType) {
        "image_title_description" -> CardType.IMAGE_ITEM
        "title_description" -> CardType.NOIMAGE_ITEM
        "text" -> CardType.TEXT_ITEM
        else -> throw JsonDataException("Unknown CardType: $cardType")
    }
}