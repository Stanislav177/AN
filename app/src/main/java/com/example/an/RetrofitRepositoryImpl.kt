package com.example.an

import retrofit2.Callback

class RetrofitRepositoryImpl : RetrofitRepository {

    private val retrofit by lazy { Retrofit.startRetrofit() }

    override fun getServer(callback: Callback<DTO>) {
        retrofit.getBloodMine().enqueue(callback)
    }
}