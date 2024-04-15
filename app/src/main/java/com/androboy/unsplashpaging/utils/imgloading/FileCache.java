package com.androboy.unsplashpaging.utils.imgloading;

import android.content.Context;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.io.File;

public class FileCache {

    private File cacheDir;

    public FileCache(Context context) {
        // Get array of possible external cache directories
        File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
        // Choose the first directory if available, otherwise use internal cache directory
        if (externalCacheDirs != null && externalCacheDirs.length > 0 && externalCacheDirs[0] != null) {
            cacheDir = externalCacheDirs[0];
        } else {
            cacheDir = context.getCacheDir();
        }
        // Ensure cache directory exists
        if (!cacheDir.exists()) {
            // Attempt to create cache directory
            boolean mkdirsResult = cacheDir.mkdirs();
            if (!mkdirsResult) {
                // Handle directory creation failure
                Log.e("MMMMM", "Failed to create cache directory");
            }
        }
    }

    public File getFile(String url){
        //I identify images by hashcode. Not a perfect solution, good for the demo.
        String filename=String.valueOf(url.hashCode());
        //Another possible solution (thanks to grantland)
        //String filename = URLEncoder.encode(url);
        return new File(cacheDir, filename);

    }

    public void clear(){
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }

}
