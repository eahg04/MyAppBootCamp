package com.example.myappbootcamp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbootcamp.Movies
import com.example.myappbootcamp.databinding.ItemMovieBinding

class MoviesAdapter(
    private val movies: List<Movies>,
    private val onClick: (Movies) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

   inner class ViewHolder(private val binding:ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie:Movies){
            itemView.setOnClickListener{
                onClick(movie)
            }
            binding.tvNameMovie.text = movie.nameMovie
            binding.tvCategory.text = movie.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
             val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}



