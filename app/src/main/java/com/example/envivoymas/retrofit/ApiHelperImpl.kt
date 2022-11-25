package com.example.envivoymas.retrofit

import com.example.envivoymas.model.LoginResponse
import retrofit2.Response


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun login(map: HashMap<String, String>): Response<LoginResponse> {
        return apiService.loginApi(map)
    }

}