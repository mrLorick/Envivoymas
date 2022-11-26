package com.example.envivoymas.retrofit

import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.model.LoginResponse
import retrofit2.Response


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun login(map: HashMap<String, String>): Response<LoginResponse> {
        return apiService.loginApi(map)
    }

    override suspend fun forgotPassword(map: HashMap<String, String>): Response<BaseResponse> {
        return apiService.forgotPasswordApi(map)
    }

    override suspend fun otpVerification(map: HashMap<String, String>): Response<BaseResponse> {
        return  apiService.otpVerificationApi(map)
    }

    override suspend fun createPassword(map: HashMap<String, String>): Response<BaseResponse> {
        return apiService.createPasswordApi(map)
    }

}