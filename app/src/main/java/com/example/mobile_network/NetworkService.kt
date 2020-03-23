package com.example.mobile_network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "https://my-json-server.typicode.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    public fun getMovieAPI () : MoviesAPI{
        return retrofit.create(MoviesAPI::class.java)
    }
}