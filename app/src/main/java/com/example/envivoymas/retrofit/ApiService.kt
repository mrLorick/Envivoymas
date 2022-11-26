package com.example.envivoymas.retrofit

import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.model.LoginResponse
import com.example.envivoymas.utils.constant.ApiConstant
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(ApiConstant.EMPLOYEE_LOGIN)
    suspend fun loginApi(@Body map: HashMap<String, String>): Response<LoginResponse>

    @POST(ApiConstant.FORGOT_PASSWORD)
    suspend fun forgotPasswordApi(@Body map: HashMap<String, String>): Response<BaseResponse>

    @GET(ApiConstant.OTP_VERIFICATION)
    suspend fun otpVerificationApi(@QueryMap map: HashMap<String, String>): Response<BaseResponse>

    @POST(ApiConstant.CREATE_PASSWORD)
    suspend fun createPasswordApi(@Body map: HashMap<String, String>): Response<BaseResponse>

}