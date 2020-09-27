package com.rsh_engineering.tkachenkoni.coroutinesretrofit.Model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("flagPNG")
    val flag: String?
)