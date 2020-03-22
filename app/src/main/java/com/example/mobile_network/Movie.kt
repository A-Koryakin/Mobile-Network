package com.example.mobile_network

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Movie(var title : String, var releaseDate : LocalDate,
            var genres : Array<String>,var poster : Int, var description : String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        LocalDate.parse(parcel.readString().orEmpty(), DateTimeFormatter.ISO_DATE),
        parcel.createStringArray()!!,
        parcel.readInt(),
        parcel.readString().orEmpty()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(releaseDate.format(DateTimeFormatter.ISO_DATE))
        parcel.writeStringArray(genres)
        parcel.writeInt(poster)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}