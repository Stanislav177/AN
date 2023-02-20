package com.example.an

import retrofit2.Call
import retrofit2.http.GET

const val URL_API_END_POINT = "api/servers.json"

interface RequestAPI {

    @GET(URL_API_END_POINT)
    fun getBloodMine(): Call<DTO>
}