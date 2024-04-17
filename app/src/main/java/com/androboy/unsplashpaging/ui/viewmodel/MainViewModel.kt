package com.androboy.unsplashpaging.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.androboy.unsplashpaging.repository.PhotosRepository
import com.androboy.unsplashpaging.ui.model.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context, private val photosRepository: PhotosRepository
) : ViewModel() {


    private val _photosResponse: MutableStateFlow<PagingData<UnsplashPhoto>> =
        MutableStateFlow(PagingData.empty())
    var photosResponse = _photosResponse.asStateFlow()
        private set

    init {
        viewModelScope.launch {
            photosRepository.getPhotos().cachedIn(viewModelScope).collect(){
                _photosResponse.value = it
            }
        }
    }

}