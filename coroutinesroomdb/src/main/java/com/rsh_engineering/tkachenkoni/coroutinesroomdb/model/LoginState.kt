package com.rsh_engineering.tkachenkoni.coroutinesroomdb.model

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
object LoginState {
    var isLoggedIn = false
    var user: User? = null

    fun logout() {
        isLoggedIn = false
        user = null
    }

    fun login(user: User) {
        isLoggedIn = true
        this.user = user
    }
}