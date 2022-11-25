package com.example.envivoymas.base

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.retrofit.ResponseWrapper
import com.example.envivoymas.utils.CommonMethod
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

open class BaseViewModel(var context: Activity) : ViewModel() {
    var isLoading: MutableLiveData<Boolean>? = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    var response: MutableLiveData<ResponseResult<ResponseWrapper<Any>>> = MutableLiveData()

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): ResponseResult<ResponseWrapper<Any>> {
        try {
            val response = call()
            val body = response.body()
            if (response.isSuccessful && response.code() == 200) {
                return ResponseResult.Success(ResponseWrapper(body, ""))
            }
            if (response.code() == 488) {
                try {
                    CoroutineScope(Dispatchers.Main).launch {
//                        userSuspendAlert(context)
                    }
                }catch (_:Exception){}
                return ResponseResult.SessionExpired(ResponseWrapper("", "Your Account is Suspend"))
            }
            if (response.code() == 401) {
                try {
                    CoroutineScope(Dispatchers.Main).launch {
//                        userUnauthorizedAlert(context)
                    }
                }catch (_:Exception){}
                return ResponseResult.SessionExpired(ResponseWrapper("", "Your Account is LogIn to Another Device."))
            }

            if (response.code() == 400) {
                val gson = Gson()
                val model: BaseResponse = gson.fromJson(response.errorBody()?.toString(), BaseResponse::class.java)

                return ResponseResult.Error(ResponseWrapper("", model.message.toString()))
            }
            return ResponseResult.Error(ResponseWrapper("", "Something went wrong, please try again"))
        } catch (e: Exception) {
            return when (e) {
                is CancellationException -> {
                    ResponseResult.NONE(ResponseWrapper(null, e))
                }

                is UnknownHostException -> {
                    CoroutineScope(Dispatchers.Main).launch {
                     try {
//                         internetLost(context)
                     }catch (_:Exception){}
                    }
                    ResponseResult.FAILURE(ResponseWrapper(null, e))
                }
                else -> {
                    ResponseResult.FAILURE(ResponseWrapper(null, e))
                }
            }
        }
    }


    fun showProgress(context: Context) {
        CommonMethod.showProgress(context)
    }

    fun hideProgress() {
        CommonMethod.hideProgress()
    }
}