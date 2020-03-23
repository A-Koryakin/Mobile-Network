package com.example.mobile_network

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MovieActivity : AppCompatActivity(), MovieListEventListener{

    lateinit var movieListFragment : MovieListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val fragmentManager = supportFragmentManager
        movieListFragment = MovieListFragment(this)
        fragmentManager.beginTransaction().add(R.id.constraint_layout, movieListFragment).commit()
    }

    override fun onClick(id: Int) {
        intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}
