package com.example.restnetwork.di

import com.example.restnetworkapi.di.NetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RestNetworkimplModule::class])
@Singleton
interface RestNetworkImplComponent {
    fun networkApi(): NetworkApi

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: RestNetworkimplModule): Builder
        fun build(): RestNetworkImplComponent
    }

    companion object {
        private fun builder(): Builder {
            return RestNetworkImplComponent.builder()
        }
    }
}
