package com.example.feature.di

import com.example.restnetworkapi.di.NetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [NetworkApi::class])
@Singleton
interface DataComponent {

//    fun networkComponent(): NetworkComponent

//    @Component.Builder
//    interface Builder{
//        fun networkComponent(): NetworkComponent
//        fun build(): DataComponent
//    }
    // Методы для предоставления зависимостей для dataModule
}