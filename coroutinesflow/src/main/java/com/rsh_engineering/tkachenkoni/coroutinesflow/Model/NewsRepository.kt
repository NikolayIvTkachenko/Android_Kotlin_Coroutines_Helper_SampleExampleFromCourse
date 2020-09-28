package com.rsh_engineering.tkachenkoni.coroutinesflow.Model


import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Created by Nikolay Tkachenko on 28, September, 2020
 *
 */

class NewsRepository {
    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/DevTides/NewsApi/master/"
        private const val NEWS_DELAY = 2000L
    }

    private val newsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)

    fun getNewsArticles(): Flow<NewsArticle> {
        return flow {
            var newsSource = newsService.getNews()
            newsSource.forEach {
                emit(it)
                delay(NEWS_DELAY)
            }
        }
    }
}