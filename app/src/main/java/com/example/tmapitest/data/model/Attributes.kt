package com.example.tmapitest.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attributes(
    val font: Font?,
    @Json(name = "text_color")
    val textColor: String?
)
