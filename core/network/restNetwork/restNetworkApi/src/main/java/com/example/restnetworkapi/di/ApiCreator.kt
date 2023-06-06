package com.example.restnetworkapi.di

interface ApiCreator {
    fun <T> createApi(api: Class<T>): T
}