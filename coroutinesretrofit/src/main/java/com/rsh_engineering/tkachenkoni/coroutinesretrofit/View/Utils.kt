package com.rsh_engineering.tkachenkoni.coroutinesretrofit.View

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rsh_engineering.tkachenkoni.coroutinesretrofit.R

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}