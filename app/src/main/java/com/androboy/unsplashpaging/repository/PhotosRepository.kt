package com.androboy.unsplashpaging.repository

import com.androboy.unsplashpaging.api.ApiRequests
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val apiInterface: ApiRequests) : BaseRepo() {


}