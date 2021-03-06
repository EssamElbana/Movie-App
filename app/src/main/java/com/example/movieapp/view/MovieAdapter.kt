package com.example.movieapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(
    private var dataSet: List<Movie> = emptyList(),
    private val onItemClicked: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.list_item_movie_image)

        init {
            imageView.setOnClickListener {
                onItemClicked(dataSet[adapterPosition])
            }
        }

        fun bind(url: String) {
            Picasso.get().load(url).placeholder(R.color.purple_700).into(imageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_movie, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position].getImageURL())
    }

    override fun getItemCount() = dataSet.size

    fun setDataSet(dataSet: List<Movie>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }
}
