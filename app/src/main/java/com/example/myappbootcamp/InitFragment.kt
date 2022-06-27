package com.example.myappbootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myappbootcamp.adapter.BestSelectAdapter
import com.example.myappbootcamp.adapter.MoviesAdapter
import com.example.myappbootcamp.databinding.FragmentInitBinding


class InitFragment : Fragment() {

    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!
    private var bestSelect: BestSelectAdapter? = null
    private var listMovies = MoviesProvider


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showMovies(listMovies.moviesList)
    }

    private fun showMovies(listMovies: List<Movies>) {
        bestSelect = BestSelectAdapter(listMovies) {
        }
        binding.recyclerViewInit.adapter = bestSelect
    }

}