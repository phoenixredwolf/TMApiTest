package com.example.tmapitest.data.model

import com.example.tmapitest.data.model.Attributes
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Title(
    val attributes: Attributes?,
    val value: String?
)
