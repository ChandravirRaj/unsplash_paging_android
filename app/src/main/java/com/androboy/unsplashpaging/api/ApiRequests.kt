package com.androboy.unsplashpaging.api

import com.androboy.unsplashpaging.ui.model.UnsplashPhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {

    @GET("photos")
    suspend fun loadPhotos(
        @Query("client_id") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Response<List<UnsplashPhoto>>
}