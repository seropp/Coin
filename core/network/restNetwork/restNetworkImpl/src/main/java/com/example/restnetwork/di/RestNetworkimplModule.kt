package com.example.restnetwork.di

import com.example.commonnetwork.di.CommonNetworkModule
import com.example.restnetworkapi.di.ApiCreator
import com.example.restnetworkapi.di.NetworkApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CommonNetworkModule::class])
class RestNetworkimplModule {

    companion object {
        @Singleton
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory
        ): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.coincap.io") // Constans
                .addConverterFactory(converterFactory)
                .build()

        @Singleton
        @Provides
            fun provideApiCreator(
            retrofit: Retrofit
        ): ApiCreator = object : ApiCreator {
            override fun <T> createApi(api: Class<T>): T =
                retrofit.create(api)
        }

        @Provides
        @Singleton
        fun provideNetworkApi(apiCreator: ApiCreator): NetworkApi = object : NetworkApi {
            override fun getApiCreator(): ApiCreator = apiCreator
        }
    }
}