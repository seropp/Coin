package com.example.feature.source.response

import com.google.gson.annotations.SerializedName

class ListOfAssetsResponse(
    @SerializedName("data")
    val allAssets: List<Assets>,

    @SerializedName("timestamp")
    val timestamp: Long
) {
    class Assets(
        @SerializedName("id")
        val id: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("symbol")
        val symbol: String,

        @SerializedName("supply")
        val supply: String,

        @SerializedName("marketCapUsd")
        val marketCapUsd: String,

        @SerializedName("maxSupply")
        val maxSupply: String,

        @SerializedName("priceUsd")
        val priceUsd: String,

        @SerializedName("rank")
        val rank: String,

        @SerializedName("volumeUsd24Hr")
        val volumeUsd24Hr: String,

        @SerializedName("vwap24Hr")
        val vwap24Hr: String,

        @SerializedName("changePercent24Hr")
        val changePercent24Hr: String
    )
}