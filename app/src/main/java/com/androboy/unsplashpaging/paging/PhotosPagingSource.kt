package com.androboy.unsplashpaging.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.androboy.unsplashpaging.api.ApiRequests
import com.androboy.unsplashpaging.ui.model.UnsplashPhoto

class PhotosPagingSource(private val apiRequests: ApiRequests) : PagingSource<Int, UnsplashPhoto>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        return try {
            val pageNumber = params.key ?: 1
            val response = apiRequests.loadPhotos(
                "pM9lVL3ek0mY_vxS3cFJ6jBKHfiZD3X0R-VR8UUCqD0",
                pageNumber,
                10
            )
            LoadResult.Page(
                data = response.body() as List<UnsplashPhoto>,
                prevKey = if (pageNumber == 1) null else pageNumber - 1, // Only paging forward.
                nextKey = if (pageNumber == response.headers()["x-total"]?.toInt()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            Log.d("MMMMM", "load:  ${e.printStackTrace()}")
            LoadResult.Error(e)

        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}