package com.example.mobile_network

import android.net.Uri
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class MovieDTO(
    @SerializedName("title")
    @Expose
    var title : String,
    @SerializedName("releaseDate")
    @Expose
    var releaseDate : String,
    @SerializedName("genres")
    @Expose
    var genres : Array<String>,
    @SerializedName("imageUrl")
    @Expose
    var imageUrl : String
)