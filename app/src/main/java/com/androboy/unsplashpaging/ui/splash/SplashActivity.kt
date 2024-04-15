package com.androboy.unsplashpaging.ui.splash

import android.annotation.SuppressLint
import androidx.viewbinding.ViewBinding
import com.androboy.unsplashpaging.R
import com.androboy.unsplashpaging.databinding.ActivitySplashBinding
import com.androboy.unsplashpaging.ui.BaseActivity
import com.androboy.unsplashpaging.ui.MainActivity
import com.androboy.unsplashpaging.utils.AppUtil
import com.androboy.unsplashpaging.utils.setFullScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private lateinit var ui: ActivitySplashBinding


    override fun layoutRes(): ViewBinding {
        setFullScreen()
        supportActionBar?.setDisplayHomeAsUpEnabled(false);
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initView() {
        ui = binding as ActivitySplashBinding
        setStatusBarColor(AppUtil.getColor(R.color.white))
        navigateActivity()
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun navigateActivity() {
        GlobalScope.launch { // context of the parent, main runBlocking coroutine
            delay(3000)
            gotoScreen()
        }
    }

    private fun gotoScreen() {
        launchActivity(MainActivity::class.java)
        finishAffinity()
    }

}