package com.example.tmapitest.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Size(
    val height: Int?,
    val width: Int?
)
