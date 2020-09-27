package com.rsh_engineering.tkachenkoni.coroutinesretrofit.Model

import retrofit2.Response
import retrofit2.http.GET

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
interface ContriesApi {
    //https://raw.githubusercontent.com/DevTides/countries/master/countriesV2.json
    @GET("/DevTides/countries/master/countriesV2.json")
    suspend fun getCountries(): Response<List<Country>>

}