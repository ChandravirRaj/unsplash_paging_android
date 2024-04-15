package com.androboy.unsplashpaging.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.androboy.unsplashpaging.api.ApiRequests
import com.androboy.unsplashpaging.paging.PhotosPagingSource
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val apiInterface: ApiRequests) : BaseRepo() {

    fun getPhotos() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { PhotosPagingSource(apiInterface) },
    ).liveData
}