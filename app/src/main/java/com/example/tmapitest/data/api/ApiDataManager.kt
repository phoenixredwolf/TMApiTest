package com.example.tmapitest.data.api

import com.example.tmapitest.data.model.DataResponse
import com.example.tmapitest.di.Module
import retrofit2.Response


object ApiDataManager {

    private val service: ApiService
    private val retrofit = Module.provideRetrofit()

    init {
        service = retrofit.create(ApiService::class.java)
    }

    suspend fun getData(): Response<DataResponse> {
        return service.getData()
    }
}