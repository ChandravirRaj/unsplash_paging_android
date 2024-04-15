package com.androboy.unsplashpaging.di

import com.androboy.unsplashpaging.api.APIInterceptor
import com.androboy.unsplashpaging.api.ApiRequests
import com.androboy.unsplashpaging.api.exception.ResultCallAdapterFactory
import com.androboy.unsplashpaging.utils.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory()).client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: APIInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().addNetworkInterceptor(authInterceptor)
            .addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiRequests {
        return retrofit.create(ApiRequests::class.java)
    }

}