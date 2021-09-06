package com.example.tmapitest.ui.viewvodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tmapitest.data.model.DataResponse
import com.example.tmapitest.data.repository.DataRepository
import com.example.tmapitest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PageViewModel @Inject constructor(repo: DataRepository): ViewModel() {

    val page: LiveData<Resource<DataResponse>> = repo.getData().asLiveData(Dispatchers.Main)
}