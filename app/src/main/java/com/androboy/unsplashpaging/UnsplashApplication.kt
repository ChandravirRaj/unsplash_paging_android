package com.androboy.unsplashpaging

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UnsplashApplication : Application() {

    companion object {
        var INSTANCE: UnsplashApplication = UnsplashApplication()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    fun getInstance(): UnsplashApplication {
        return INSTANCE
    }
}