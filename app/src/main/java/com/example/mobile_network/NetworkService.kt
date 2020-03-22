package com.example.mobile_network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    public fun getMovieAPI (){
        retrofit.create(MoviesAPI::class.java)
    }
}