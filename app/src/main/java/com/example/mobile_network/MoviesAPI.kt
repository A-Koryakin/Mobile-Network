package com.example.mobile_network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MoviesAPI {
    @GET("/films/")
    fun getAllMovies(): Call<List<MovieDTO>>?
    @GET("/film/{id}")
    fun getMovieById(@Path("id") id: Int): Call<MovieDetailsDTO>?
}