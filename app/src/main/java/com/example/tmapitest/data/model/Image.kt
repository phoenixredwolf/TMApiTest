package com.example.tmapitest.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    val size: Size?,
    val url: String?
)
