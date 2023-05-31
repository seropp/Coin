package com.example.websocket.di

import com.example.commonnetwork.di.CommonNetworkModule
import com.example.websocket.websocket.SocketListener
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

@Module(includes = [CommonNetworkModule::class])
class WebsocketModule {

    @Provides
    fun provideWebsocket(
        client: OkHttpClient,
        gson: Gson
    ): WebSocket =
        client.newWebSocket(
            request = Request.Builder()
                .url("wss://ws.coincap.io")
                //Добавить окончания как в RestApi запросах
                // wss://ws.coincap.io/trades/binance
                // etc
                .build(),
            listener = SocketListener(
                gson = gson
            )
        )
}