package com.example.funprimetask.api

import com.example.funprimetask.PostItem
import retrofit2.Call
import retrofit2.http.GET


interface APIService {

    @GET("photos")
    suspend fun getPosts() : List<PostItem>

}