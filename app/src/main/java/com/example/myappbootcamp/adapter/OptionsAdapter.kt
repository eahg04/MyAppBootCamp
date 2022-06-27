package com.example.myappbootcamp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbootcamp.Options
import com.example.myappbootcamp.databinding.ItemOptionsBinding

class OptionsAdapter(
    private val options: List<Options>,
    private val onClick: (Options) -> Unit
) : RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemOptionsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(option:Options){
            itemView.setOnClickListener{
                onClick(option)
            }
            binding.tvDescription.text = option.description
            binding.tvTitle.text = option.title
            binding.tvCount.text = option.count
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOptionsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(options[position])
    }

    override fun getItemCount(): Int = options.size

}