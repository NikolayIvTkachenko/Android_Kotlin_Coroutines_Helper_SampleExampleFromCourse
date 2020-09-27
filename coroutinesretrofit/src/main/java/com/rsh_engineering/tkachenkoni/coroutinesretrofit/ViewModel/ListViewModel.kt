package com.rsh_engineering.tkachenkoni.coroutinesretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rsh_engineering.tkachenkoni.coroutinesretrofit.Model.Country
import com.rsh_engineering.tkachenkoni.coroutinesretrofit.Model.CountryService
import kotlinx.coroutines.*

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
class ListViewModel: ViewModel() {

    val countryService = CountryService.getCountryService()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = countryService.getCountries()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    countries.value = response.body()
                    countryLoadError.value = null
                    loading.value = false
                }else{
                    onError("Error: ${response.message()}")
                }
            }
        }



        //Just test UI and Logic
//        val dummyData = generateDummyCountries()
//        countries.value = dummyData
//        countryLoadError.value = ""
//        loading.value = false
    }

    private fun generateDummyCountries(): List<Country> {
        val countries = arrayListOf<Country>()
        countries.add(Country("Country1",  "Capital1",""))
        countries.add(Country("Country2",  "Capital2",""))
        countries.add(Country("Country3",  "Capital3",""))
        countries.add(Country("Country4",  "Capital4",""))
        countries.add(Country("Country5",  "Capital5",""))
        return countries
    }

    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}