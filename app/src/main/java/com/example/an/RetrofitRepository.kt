package com.example.an

import retrofit2.Callback

interface RetrofitRepository {
    fun getServer(callback: Callback<DTO>)
}