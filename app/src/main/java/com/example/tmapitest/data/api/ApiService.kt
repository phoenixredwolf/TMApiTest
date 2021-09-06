package com.example.tmapitest.data.api

import com.example.tmapitest.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("test/home")
    suspend fun getData(): Response<DataResponse>

}