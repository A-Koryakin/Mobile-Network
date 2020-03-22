package com.example.mobile_network

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val moviesDataset: List<Movie>, var listenerMovie: MovieListEventListener)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(relativeLayout: RelativeLayout)
        : RecyclerView.ViewHolder(relativeLayout){
        private val img: ImageView = relativeLayout.findViewById(R.id.img)
        private val title: TextView = relativeLayout.findViewById(R.id.title)
        private val releaseDate: TextView = relativeLayout.findViewById(R.id.release_date)
        private val genres = relativeLayout.findViewById<TextView>(R.id.genres_list)

        public lateinit var movie : Movie

        fun setMovieData(_movie : Movie){
            movie = _movie
            img.setImageResource(movie.poster)
            title.text = movie.title
            releaseDate.text = movie.releaseDate.toString()
            genres.text = movie.genres.joinToString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val relativeLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_member,parent,false) as RelativeLayout

        val movieViewHolder = MovieViewHolder(relativeLayout)

        relativeLayout.setOnClickListener {listenerMovie.onClick(movieViewHolder.movie)}

        return movieViewHolder
    }

    override fun getItemCount() = moviesDataset.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setMovieData(moviesDataset[position])
    }
}