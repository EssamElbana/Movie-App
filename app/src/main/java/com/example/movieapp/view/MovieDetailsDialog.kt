package com.example.movieapp.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_details_dialog.*


class MovieDetailsDialog : DialogFragment() {
    var movie: Movie? = null

    init {
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_details_dialog, container)
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(
            R.style.dialog_animation_fade
        )
    }

    fun initMovie(movie: Movie) {
        this.movie = movie
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE);
        Picasso.get().load(movie?.getImageURL())
            .placeholder(R.color.purple_700)
            .into(movie_image)
        movie_title.text = movie?.title
        movie_overview.text = movie?.overview
        movie_release_date.text = movie?.release_date
    }
}