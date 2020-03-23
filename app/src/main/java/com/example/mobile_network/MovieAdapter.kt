package com.example.mobile_network

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val moviesDataset: List<MovieDTO>, var listenerMovie: MovieListEventListener)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(relativeLayout: RelativeLayout)
        : RecyclerView.ViewHolder(relativeLayout){
        val img: ImageView = relativeLayout.findViewById(R.id.img)
        val title: TextView = relativeLayout.findViewById(R.id.title)
        val releaseDate: TextView = relativeLayout.findViewById(R.id.release_date)
        val genres = relativeLayout.findViewById<TextView>(R.id.genres_list)
        val context = relativeLayout.context
        var id = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val relativeLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_member,parent,false) as RelativeLayout

        val movieViewHolder = MovieViewHolder(relativeLayout)

        relativeLayout.setOnClickListener {listenerMovie.onClick(movieViewHolder.id + 1)}

        return movieViewHolder
    }

    override fun getItemCount() = moviesDataset.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.id = position
        Picasso.with(holder.context).load(moviesDataset[position].imageUrl).into(holder.img)
        holder.title.text = moviesDataset[position].title
        holder.releaseDate.text = moviesDataset[position].releaseDate.toString()
        holder.genres.text = moviesDataset[position].genres.joinToString()
    }
}