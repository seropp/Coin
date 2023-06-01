package com.example.restnetwork.di

import com.example.commonnetwork.di.CommonNetworkModule
import com.example.restnetwork.ApiCreator
import com.example.restnetwork.dependencies.Dependencies
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [RestApiModule::class])
interface RestComponent : Dependencies {
    override fun getApiCreator(): ApiCreator
}


@Module(includes = [CommonNetworkModule::class])
class RestApiModule {

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


    @Provides
    @Singleton
    fun getApiCreator(retrofit: Retrofit): ApiCreator =
        retrofit.create(ApiCreator::class.java)

}
