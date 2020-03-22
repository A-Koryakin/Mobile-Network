package com.example.mobile_network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URL
import java.time.LocalDate

data class MovieDetailsDTO(
    @SerializedName("title")
    @Expose
    var title : String,
    @SerializedName("releaseDate")
    @Expose
    var releaseDate : LocalDate,
    @SerializedName("genres")
    @Expose
    var genres : Array<String>,
    @SerializedName("imageUrl")
    @Expose
    var imageUrl : URL,
    @SerializedName("description")
    @Expose
    var description : String
)