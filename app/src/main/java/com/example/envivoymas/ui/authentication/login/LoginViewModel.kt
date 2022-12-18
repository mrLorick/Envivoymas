package com.example.envivoymas.ui.authentication.login

import android.app.Activity
import androidx.databinding.ObservableField
import com.example.envivoymas.base.BaseViewModel
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.retrofit.ResponseWrapper
import com.example.envivoymas.retrofit.apiHelper
import com.example.envivoymas.utils.constant.ApiConstant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(activity: Activity) : BaseViewModel(activity){
    var emailId = ObservableField("Lorickmr@gmail.com")
    var password = ObservableField("Lorick@123")

    /** this function for hit Login Api*/
    fun loginApi() {
        isLoading?.postValue(true)
        val requestData = hashMapOf(
            ApiConstant.ApiParams.EMAIL.value to emailId.get().toString(),
            ApiConstant.ApiParams.PASSWORD.value to password.get().toString(),
        )

        CoroutineScope(Dispatchers.IO).launch {
            val result: ResponseResult<ResponseWrapper<Any>> = getResult {
                apiHelper().login(requestData)
            }
            isLoading?.postValue(false)
            response.postValue(result)
        }
    }
}