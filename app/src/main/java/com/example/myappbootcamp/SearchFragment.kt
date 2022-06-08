package com.example.myappbootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappbootcamp.adapter.MoviesAdapter
import com.example.myappbootcamp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private var moviesAdapter: MoviesAdapter? = null
    private var listMovies = MoviesProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showMovies(listMovies.moviesList)
    }

    fun showMovies(listMovies: List<Movies>) {
        moviesAdapter = MoviesAdapter(listMovies) { movies ->
        }
        binding.recyclerView.adapter = moviesAdapter
    }
}


