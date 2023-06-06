package com.example.coin.di

import android.app.Application
import com.example.feature.di.DaggerDataComponent
import com.example.feature.di.DataComponent
import com.example.restnetwork.di.DaggerRestNetworkImplComponent
import com.example.restnetwork.di.RestNetworkImplComponent
import com.example.restnetwork.di.RestNetworkimplModule
import dagger.Component
import dagger.Module


class CoinApplication : Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()

        val networkApi = DaggerRestNetworkImplComponent.builder()
            .networkModule(RestNetworkimplModule())
            .build()
            .networkApi()

        dataComponent = DaggerDataComponent.builder()
            .networkApi(networkApi)
            .build()
    }
}

@Component(modules = [RestNetworkimplModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}
