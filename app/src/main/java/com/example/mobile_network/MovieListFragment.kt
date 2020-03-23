package com.example.mobile_network
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieListFragment (var listenerMovie: MovieListEventListener) : Fragment() {
    val movies = mutableListOf<MovieDTO>()

    private lateinit var viewOfFragmentMovieList: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        viewOfFragmentMovieList = inflater.inflate(
            R.layout.fragment_movie_list, container, false
        )
        setMovies(movies)
        return viewOfFragmentMovieList
    }

    private fun setMovies(movies: List<MovieDTO>){
        viewManager = LinearLayoutManager(context)
        viewAdapter = MovieAdapter(movies, listenerMovie)

        createHelper()

        recyclerView = viewOfFragmentMovieList.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun createHelper() {
        NetworkService.getMovieAPI().getAllMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                movies.clear()
                movies.addAll(result)
                recyclerView.adapter?.notifyDataSetChanged()
            }, { error ->
                error.printStackTrace()
            })
    }
}