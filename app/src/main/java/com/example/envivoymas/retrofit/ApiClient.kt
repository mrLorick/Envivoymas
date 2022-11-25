package com.example.envivoymas.retrofit

import com.example.envivoymas.utils.constant.ApiConstant
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun getApiService(): ApiService {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return Retrofit.Builder()
        .baseUrl(ApiConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(OkHttpClient().newBuilder()
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(provideHeaderInterceptor())
            .addInterceptor(interceptor)
            .build()
        )
        .build().create(ApiService::class.java)
}

private fun provideHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        // todo - Code for request with auth token
//        val accessToken: String = PreferenceUtil.get().get(PreferenceUtil.ACCESS_TOKEN)
//        Log.d("Authorization",accessToken)
//        if (!TextUtils.isEmpty(accessToken)) {
//            val request: Request = chain.request().newBuilder()
//                .addHeader("Accept", "application/x-www-form-urlencoded")
//                .addHeader("Authorization", "Bearer $accessToken").build()
//            chain.proceed(request)
//        } else {
            val request: Request = chain.request().newBuilder()
                .addHeader("Accept", "application/json").build()
            chain.proceed(request)
        }
//    }
}


fun apiHelper(): ApiHelperImpl = ApiHelperImpl(getApiService())

