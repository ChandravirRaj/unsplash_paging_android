package com.androboy.unsplashpaging.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.androboy.unsplashpaging.databinding.ActivityMainBinding
import com.androboy.unsplashpaging.ui.adapters.LoaderAdapter
import com.androboy.unsplashpaging.ui.adapters.PhotosPagingAdapter
import com.androboy.unsplashpaging.ui.model.UnsplashPhoto
import com.androboy.unsplashpaging.ui.viewmodel.MainViewModel
import com.androboy.unsplashpaging.utils.imgloading.ImageLoader
import com.androboy.unsplashpaging.utils.invisible
import com.androboy.unsplashpaging.utils.visible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var ui: ActivityMainBinding
    private lateinit var imgLoader: ImageLoader
    private lateinit var viewModel: MainViewModel
    private lateinit var photoPagingAdapter: PhotosPagingAdapter

    override fun layoutRes(): ViewBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        ui = binding as ActivityMainBinding

        setObserver()
        setListeners()
    }

    private fun setListeners() {

        ui.progressBar.visible()
        photoPagingAdapter = PhotosPagingAdapter()
        ui.recyclerView.layoutManager = GridLayoutManager(this,2)
        ui.recyclerView.setHasFixedSize(true)
        ui.recyclerView.adapter = photoPagingAdapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(), footer = LoaderAdapter()
        )

        imgLoader = ImageLoader(this)
        photoPagingAdapter.setImageLoader(imgLoader)
    }

    private fun setObserver() {
        viewModel.photosLiveData.observe(this, photosObserver)
    }

    private val photosObserver: Observer<PagingData<UnsplashPhoto>> = Observer {
        ui.progressBar.invisible()
        photoPagingAdapter.submitData(lifecycle, it)
    }
}