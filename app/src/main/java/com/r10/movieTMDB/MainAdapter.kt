package com.r10.movieTMDB

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.r10.movieTMDB.data.response.ResultsItem
import com.r10.moviezzz.databinding.ItemCharacterBinding

class MainAdapter(private val listCharacters: List<ResultsItem>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    class ListViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: ResultsItem, context: Context) {
            with(binding) {
                icTitle.text = character.title
                // Load gambar poster menggunakan Glide
                Glide.with(itemView)
                    .load("https://image.tmdb.org/t/p/w500${character.posterPath}")
                    .into(icImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCharacters.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listCharacters[position], context)
    }
}
