package com.rsh_engineering.tkachenkoni.coroutinesflow.Model

import com.google.gson.annotations.SerializedName
/**
 *
 * Created by Nikolay Tkachenko on 28, September, 2020
 *
 */

data class NewsArticle(
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    @SerializedName("imageUrl")
    val urlToImage: String? = null,
    val publishedAt: String? = null
)
