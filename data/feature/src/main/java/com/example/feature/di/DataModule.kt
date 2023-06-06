package com.example.feature.di

import com.example.restnetworkapi.di.ApiCreator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMyService(apiCreator: ApiCreator): MyService =
        apiCreator.createApi(MyService::class.java)
}

interface MyService{

}