package com.example.envivoymas.retrofit

sealed class ResponseResult<out T> {
    data class Success<T>(val result: T) : ResponseResult<T>()
    data class Error<T>(val result: T) : ResponseResult<T>()
    data class FAILURE<T>(val msg: T) : ResponseResult<T>()
    data class NONE<T>(val msg: T) : ResponseResult<T>()
    data class SessionExpired<T>(val msg: T) : ResponseResult<T>()
}
data class ResponseWrapper<T>(val data: Any?, val errorMsg: Any)