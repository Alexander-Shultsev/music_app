package com.example.musucapp.model

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

interface Query {

    @GET("posts")
    suspend fun getAllPost(): Response<ArrayList<Post>>

    @POST("posts")
    @FormUrlEncoded
    suspend fun sendPost(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String,
    ) : Response<Post>

}