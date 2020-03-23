package com.example.mobile_network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


public interface MoviesAPI {
    @GET("/A-Koryakin/JSON-server-for-mobile/films/")
    public fun getAllMovies(): Observable<List<MovieDTO>>
    @GET("/A-Koryakin/JSON-server-for-mobile/film/{id}")
    public fun getMovieById(@Path("id") id: Int): Observable<MovieDetailsDTO>
}