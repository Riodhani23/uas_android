package com.r10.movieTMDB.data.local

import android.content.Context
import com.r10.movieTMDB.data.response.ResponseLogin

class UserPreferences(context: Context) {
    companion object {
        private const val PREF_NAME = "user_preferences"
        private const val USERNAME = "username"
        private const val PASSWORD = "password"
    }

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // fungsi untuk menyimpan data
    fun setUser(responseLogin: ResponseLogin){
        val set = preferences.edit()
        set.putString(USERNAME, responseLogin.username)
        set.putString(PASSWORD, responseLogin.password)

        set.apply()
    }

    // fungsi untuk mengambil data
    fun getUser(): ResponseLogin {
        val data = ResponseLogin()
        data.username = preferences.getString(USERNAME, "")
        data.password = preferences.getString(PASSWORD, "")

        return data
    }

}