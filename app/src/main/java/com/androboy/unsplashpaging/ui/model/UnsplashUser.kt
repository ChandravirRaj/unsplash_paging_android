package com.androboy.unsplashpaging.ui.model

import android.os.Parcelable
import com.androboy.unsplashpaging.ui.model.UnsplashLinks
import com.androboy.unsplashpaging.ui.model.UnsplashUrls
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashUser(
    val id: String,
    val username: String,
    val name: String,
    val portfolio_url: String?,
    val bio: String?,
    val location: String?,
    val total_likes: Int,
    val total_photos: Int,
    val total_collection: Int,
    val profile_image: UnsplashUrls,
    val links: UnsplashLinks
) : Parcelable