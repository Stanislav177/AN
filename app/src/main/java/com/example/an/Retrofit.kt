package com.example.an

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val URL_API_BASE = "https://bloodmine-pe.ru/"
const val URL_API_BASE = "https://fakerapi.it/"

interface Retrofit {

    companion object {
        fun startRetrofit(): RequestAPI {
            val retrofit = Retrofit.Builder().baseUrl(URL_API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RequestAPI::class.java)
        }
    }
}