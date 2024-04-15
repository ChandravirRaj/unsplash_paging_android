package com.androboy.unsplashpaging.utils

import android.content.Context
import android.net.ConnectivityManager
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.androboy.unsplashpaging.R
import com.androboy.unsplashpaging.UnsplashApplication
import java.util.Objects


object AppUtil {

    fun isConnection(): Boolean {
        return isConnection(true)
    }

    private fun isConnection(notShowMsg: Boolean): Boolean {
        val connectivityManager = UnsplashApplication.INSTANCE
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo =
            Objects.requireNonNull(connectivityManager)
                .activeNetworkInfo
        val isNetwork =
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        if (!isNetwork && !notShowMsg) {
            showToast(
                UnsplashApplication.INSTANCE.resources
                    .getString(R.string.msg_network_connection)
            )
        }
        return isNetwork
    }


    fun getColor(color: Int): Int {
        return ContextCompat.getColor(UnsplashApplication.INSTANCE, color)
    }


    fun preventTwoClick(view: View?) {
        if (view != null) {
            view.isEnabled = false
            view.postDelayed(Runnable { view.isEnabled = true }, 700)
        }
    }


    fun showToast(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(UnsplashApplication.INSTANCE, msg, Toast.LENGTH_LONG)
                .show()
        }
    }

}