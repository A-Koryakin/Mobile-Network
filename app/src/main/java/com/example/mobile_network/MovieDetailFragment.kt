package com.example.mobile_network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailFragment(var pos: Int) : Fragment() {
    private lateinit var viewOfFragmentMovieDetails: View
    private lateinit var movie : MovieDetailsDTO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        viewOfFragmentMovieDetails = inflater.inflate(
            R.layout.movie_details, container, false
        )
        createHelper()
        return viewOfFragmentMovieDetails
    }

    private fun createHelper() {
        NetworkService.getMovieAPI().getMovieById(pos)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                movie = result
                setMovies(movie)
            }, { error ->
                error.printStackTrace()
            })
    }

    private fun setMovies(movie: MovieDetailsDTO){
        val img = viewOfFragmentMovieDetails.findViewById<ImageView>(R.id.img)
        val title: TextView = viewOfFragmentMovieDetails.findViewById(R.id.title)
        val releaseDate: TextView = viewOfFragmentMovieDetails.findViewById(R.id.release_date)
        val genres = viewOfFragmentMovieDetails.findViewById<TextView>(R.id.genres_list)
        val description = viewOfFragmentMovieDetails.findViewById<TextView>(R.id.description)

        Picasso.with(viewOfFragmentMovieDetails.context).load(movie.imageUrl).into(img)
        title.text = movie.title
        releaseDate.text = movie.releaseDate.toString()
        genres.text = movie.genres.joinToString()
        description.text = movie.description
    }
}