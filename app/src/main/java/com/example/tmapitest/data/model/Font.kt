package com.example.tmapitest.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Font(
    val size: Int?
)
