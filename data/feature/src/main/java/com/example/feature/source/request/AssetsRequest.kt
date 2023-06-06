package com.example.feature.source.request

import com.google.gson.annotations.SerializedName

class AssetsRequest(
    @SerializedName("search")
    val search: String?,

    @SerializedName("ids")
    val ids: List<String>?,

    @SerializedName("limit")
    val limit: Int?,

    @SerializedName("offset")
    val offset: Int?
)