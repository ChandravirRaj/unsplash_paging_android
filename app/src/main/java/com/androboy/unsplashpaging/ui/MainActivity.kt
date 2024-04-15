package com.androboy.unsplashpaging.ui

import androidx.viewbinding.ViewBinding
import com.androboy.unsplashpaging.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun layoutRes(): ViewBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        ui = binding as ActivityMainBinding
    }


}