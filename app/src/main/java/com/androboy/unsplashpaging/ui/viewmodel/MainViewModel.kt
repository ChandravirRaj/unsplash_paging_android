package com.androboy.unsplashpaging.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.androboy.unsplashpaging.repository.PhotosRepository
import com.androboy.unsplashpaging.ui.model.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context, private val photosRepository: PhotosRepository
) : ViewModel() {


    val _photosLiveData = photosRepository.getPhotos().cachedIn(viewModelScope)
    val photosLiveData: LiveData<PagingData<UnsplashPhoto>>
        get() = _photosLiveData

}