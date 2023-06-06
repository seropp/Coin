package com.example.feature.di

import com.example.feature.source.network.AssetsService
import com.example.restnetworkapi.di.ApiCreator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMyService(apiCreator: ApiCreator): AssetsService =
        apiCreator.createApi(AssetsService::class.java)
}
