package com.example.envivoymas.retrofit

import com.example.envivoymas.model.LoginResponse
import com.example.envivoymas.utils.constant.ApiConstant
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(ApiConstant.EMPLOYEE_LOGIN)
    suspend fun loginApi(@Body map: HashMap<String, String>): Response<LoginResponse>


}