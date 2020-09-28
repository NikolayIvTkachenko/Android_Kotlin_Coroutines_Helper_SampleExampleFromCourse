package com.rsh_engineering.tkachenkoni.coroutinesflow.ViewModel

/**
 *
 * Created by Nikolay Tkachenko on 28, September, 2020
 *
 */

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rsh_engineering.tkachenkoni.coroutinesflow.Model.NewsRepository


class ListViewModel: ViewModel() {

    val newsArticles = NewsRepository().getNewsArticles().asLiveData()

}