package com.example.an

import retrofit2.Call
import retrofit2.http.GET

//const val URL_API_END_POINT = "api/servers.json"
const val URL_API_END_POINT = "api/v1/images?_quantity=100&_locale=en_US&_type=kittens&_height=300"

interface RequestAPI {

    @GET(URL_API_END_POINT)
    fun getBloodMine(): Call<TestDTO>
}