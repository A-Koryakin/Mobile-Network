package com.example.mobile_network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val fragmentManager = supportFragmentManager
        val arg = intent.extras
        val id: Int = arg!!["id"] as Int
        val movieDetailFragment = MovieDetailFragment(id)
        fragmentManager.beginTransaction().add(R.id.constraint_layout, movieDetailFragment).commit()
    }
}