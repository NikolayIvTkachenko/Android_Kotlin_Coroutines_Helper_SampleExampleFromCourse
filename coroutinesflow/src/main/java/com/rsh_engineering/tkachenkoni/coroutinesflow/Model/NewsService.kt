package com.rsh_engineering.tkachenkoni.coroutinesflow.Model

import retrofit2.http.GET
/**
 *
 * Created by Nikolay Tkachenko on 28, September, 2020
 *
 */
interface NewsService {
    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}