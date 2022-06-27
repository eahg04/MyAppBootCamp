package com.example.myappbootcamp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbootcamp.Movies
import com.example.myappbootcamp.databinding.ItemRecyclerInitBinding

class BestSelectAdapter(
    private val bestMovies: List<Movies>,
    private val onClick: (Movies) -> Unit

) : RecyclerView.Adapter<BestSelectAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRecyclerInitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movies) {
            itemView.setOnClickListener {
                onClick(movie)
            }
            binding.tvCalification.text = movie.calification
            binding.tvName.text = movie.nameMovie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSelectAdapter.ViewHolder {
        val binding = ItemRecyclerInitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: BestSelectAdapter.ViewHolder, position: Int) {
        holder.bind(bestMovies[position])
    }
    override fun getItemCount(): Int = bestMovies.size

}