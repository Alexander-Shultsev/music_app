package com.example.musucapp.model

import retrofit2.Response
import retrofit2.http.GET

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

interface Query {

    @GET("posts")
    suspend fun getAllPost(): Response<ArrayList<Post>>

}