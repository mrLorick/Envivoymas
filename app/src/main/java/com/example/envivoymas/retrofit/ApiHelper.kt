package com.example.envivoymas.retrofit

import com.example.envivoymas.model.LoginResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun login(map: HashMap<String, String>): Response<LoginResponse>
}