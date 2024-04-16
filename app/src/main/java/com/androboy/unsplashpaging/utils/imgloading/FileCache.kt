package com.androboy.unsplashpaging.utils.imgloading

import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat
import java.io.File

class FileCache(context: Context) {
    private var cacheDir: File? = null

    init {
        // Get array of possible external cache directories
        val externalCacheDirs = ContextCompat.getExternalCacheDirs(context)
        // Choose the first directory if available, otherwise use internal cache directory
        cacheDir =
            if (externalCacheDirs.isNotEmpty() && externalCacheDirs[0] != null) {
                externalCacheDirs[0]
            } else {
                context.cacheDir
            }
        // Ensure cache directory exists
        if (!cacheDir!!.exists()) {
            // Attempt to create cache directory
            val mkdirsResult = cacheDir!!.mkdirs()
            if (!mkdirsResult) {
                // Handle directory creation failure
                Log.e("MMMMM", "Failed to create cache directory")
            }
        }
    }

    fun getFile(url: String): File {
        //I identify images by hashcode. Not a perfect solution, good for the demo.
        val filename = url.hashCode().toString()
        //Another possible solution (thanks to grantland)
        //String filename = URLEncoder.encode(url);
        return File(cacheDir, filename)
    }

    fun clear() {
        val files = cacheDir!!.listFiles() ?: return
        for (f in files) f.delete()
    }
}