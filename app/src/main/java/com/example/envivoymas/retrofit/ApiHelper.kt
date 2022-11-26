package com.example.envivoymas.retrofit

import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.model.LoginResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun login(map: HashMap<String, String>): Response<LoginResponse>
    suspend fun forgotPassword(map: HashMap<String, String>): Response<BaseResponse>
    suspend fun otpVerification(map: HashMap<String, String>): Response<BaseResponse>
    suspend fun createPassword(map: HashMap<String, String>): Response<BaseResponse>
}