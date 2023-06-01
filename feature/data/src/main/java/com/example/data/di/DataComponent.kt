package com.example.data.di

import com.example.restnetwork.ApiCreator
import com.example.restnetwork.dependencies.Dependencies
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

@Component(dependencies = [ApiCreator::class])
interface DataComponent {

    @Component.Builder
    abstract class Builder {
        abstract fun build(): DataComponent
        @BindsInstance
        abstract fun apiCreator(apiCreator: ApiCreator): Builder
    }
}

@Module
class ApiCreatorModule(private val apiCreatorProvider: Dependencies) {
    @Provides
    fun provideApiCreatorProvider(): Dependencies = apiCreatorProvider
}

interface ServiceApi {

    @GET
    fun get(
        @Url url: String
    ): ResponseBody
}