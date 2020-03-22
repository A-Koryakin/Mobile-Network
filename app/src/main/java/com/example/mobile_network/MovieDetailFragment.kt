package com.example.mobile_network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MovieDetailFragment(var movie: Movie) : Fragment() {
    private lateinit var viewOfFragmentMovieDetails: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        viewOfFragmentMovieDetails = inflater.inflate(
            R.layout.movie_details, container, false
        )
        setMovies(movie)
        return viewOfFragmentMovieDetails
    }

    private fun setMovies(movie: Movie){
        val img = viewOfFragmentMovieDetails.findViewById<ImageView>(R.id.img)
        val title: TextView = viewOfFragmentMovieDetails.findViewById(R.id.title)
        val releaseDate: TextView = viewOfFragmentMovieDetails.findViewById(R.id.release_date)
        val genres = viewOfFragmentMovieDetails.findViewById<TextView>(R.id.genres_list)
        val description = viewOfFragmentMovieDetails.findViewById<TextView>(R.id.description)

        img.setImageResource(movie.poster)
        title.text = movie.title
        releaseDate.text = movie.releaseDate.toString()
        genres.text = movie.genres.joinToString()
        description.text = movie.description
    }
}