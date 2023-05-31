package com.example.restnetwork.di

import com.example.commonnetwork.di.CommonNetworkModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CommonNetworkModule::class])
class RestApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.coincap.io") // Constans
//            .addConverterFactory()
            .build()
}