package com.rsh_engineering.tkachenkoni.coroutinesretrofit.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
object CountryService {
    private val BASE_URL = "https://raw.githubusercontent.com"

    fun getCountryService(): ContriesApi{
        return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContriesApi::class.java)
    }
}