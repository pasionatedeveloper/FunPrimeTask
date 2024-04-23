package com.example.funprimetask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(var repository: MyRepository) : ViewModel() {

    var postsLiveData = repository.postsLiveData

    fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPosts()
        }
    }
}