package com.rsh_engineering.tkachenkoni.coroutinesflow.View

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rsh_engineering.tkachenkoni.coroutinesflow.R

/**
 *
 * Created by Nikolay Tkachenko on 28, September, 2020
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