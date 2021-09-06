package com.example.tmapitest.data.repository

import com.example.tmapitest.data.api.ApiDataManager
import com.example.tmapitest.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DataRepository {

    fun getData() = flow {
        emit(Resource.Loading)
        val response = ApiDataManager.getData()
        val state = if (response.isSuccessful) {
            response.body()?.let {
                Resource.Success(it)
            } ?: Resource.Error("No data found")
        } else Resource.Error("Error fetching data")
        emit(state)
    }.flowOn(Dispatchers.IO)
}