package com.androboy.unsplashpaging.ui.splash

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.androboy.unsplashpaging.R
import com.androboy.unsplashpaging.UnsplashApplication
import com.androboy.unsplashpaging.databinding.ActivitySplashBinding
import com.androboy.unsplashpaging.ui.BaseActivity
import com.androboy.unsplashpaging.ui.MainActivity
import com.androboy.unsplashpaging.utils.AppUtil
import com.androboy.unsplashpaging.utils.DialogUtils
import com.androboy.unsplashpaging.utils.setFullScreen
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
        setStatusBarColor(AppUtil.getColor(R.color.black))
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

        val whatPermission1 = ArrayList<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            whatPermission1.add(Manifest.permission.ACCESS_MEDIA_LOCATION)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            whatPermission1.add(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            whatPermission1.add(Manifest.permission.READ_EXTERNAL_STORAGE)
            whatPermission1.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        Dexter.withContext(this).withPermissions(whatPermission1)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(multiplePermissionsReport: MultiplePermissionsReport) {
                    if (multiplePermissionsReport.areAllPermissionsGranted()) {
                        launchActivity(MainActivity::class.java)
                        finishAffinity()
                    } else {
                        DialogUtils.showAlert(
                            this@SplashActivity,
                            "Please Allow Storage Permission",
                            "App required storage permission to cache images ",
                            UnsplashApplication.INSTANCE.getString(android.R.string.ok),
                            UnsplashApplication.INSTANCE.getString(android.R.string.cancel)
                        ) { isOk ->
                            if (isOk) {
                                AppUtil.openAppPermissionScreen(this@SplashActivity)
                            }
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    list: List<PermissionRequest>, permissionToken: PermissionToken
                ) {
                    permissionToken.continuePermissionRequest()
                }
            }).withErrorListener { dexterError: DexterError ->
                Log.d(
                    "TAG", "dexterError : $dexterError"
                )
            }.check()
    }

}