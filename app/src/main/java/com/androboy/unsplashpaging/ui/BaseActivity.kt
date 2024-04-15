package com.androboy.unsplashpaging.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.androboy.unsplashpaging.utils.AppUtil


/**
 * BaseActivity : this one is base activity for all sub activities which are using in this project
 * it extends AppCompatActivity()
 * it has all commonly used methods and variables
 *
 * */
abstract class BaseActivity : AppCompatActivity() {


    // View Binding for root UI
    lateinit var binding: ViewBinding

    /**
     * Layout resource for View Binding for Activity
     */
    abstract fun layoutRes(): ViewBinding

    abstract fun initView()

    /**
     * Set All UI resource in Window
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = layoutRes()
        setContentView(binding.root)
        initView()
    }

    /**
     * Set status bar color
     */
    open fun setStatusBarColor(color: Int) {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = color
    }


    /**
     * Launch activity using class concept
     *
     * @param classType launching class
     */
    open fun launchActivity(classType: Class<out BaseActivity>) {
        startActivity(Intent(this, classType))
    }


    open fun launchActivity(
        classType: Class<out BaseActivity>, view: View
    ) {
        AppUtil.preventTwoClick(view)
        startActivity(Intent(this, classType))
    }


    open fun launchActivity(
        classType: Class<out BaseActivity>, bundle: Bundle
    ) {
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    open fun launchActivityForResult(
        classType: Class<out BaseActivity>, requestCode: Int
    ) {
        val intent = Intent(this, classType)
        startActivityForResult(intent, requestCode)
    }

    /**
     * Launch activity using class concept and pass data using bundle
     *
     * @param classType launching class
     */
    open fun launchActivity(
        bundle: Bundle, classType: Class<out BaseActivity>
    ) {
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

}