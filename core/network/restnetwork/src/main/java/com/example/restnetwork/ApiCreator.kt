package com.example.restnetwork

interface ApiCreator {
    fun <T> create(api: Class<T>): T
}