package com.example.funprimetask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.funprimetask.api.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyRepository(private var apiService : APIService) {

    private var liveData = MutableLiveData<List<PostItem>>()
    var postsLiveData : LiveData<List<PostItem>> = liveData

    suspend fun getPosts(){

        CoroutineScope(Dispatchers.IO).launch {
            liveData.postValue(apiService.getPosts())
        }
    }
}