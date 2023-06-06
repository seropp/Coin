package com.example.feature.source.network

import com.example.feature.source.response.ListOfAssetsResponse
import retrofit2.http.GET

interface AssetsService {

    @GET("v2/assets/bitcoin")
    fun getAllAssets(): ListOfAssetsResponse
}