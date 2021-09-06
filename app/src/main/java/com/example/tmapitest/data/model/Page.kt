package com.example.tmapitest.data.model

import com.example.tmapitest.data.model.Cards
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Page(
    val cards: List<Cards> = listOf()
)

