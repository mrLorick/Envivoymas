package com.example.envivoymas.ui.authentication.forgotPassword

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

class ForgotViewModel(activity: Activity) : BaseViewModel(activity){
    var emailId = ObservableField("")

    /** this function for hit forgot password Api*/
    fun forgotPasswordApi() {
        isLoading?.postValue(true)
        val requestData = hashMapOf(
            ApiConstant.ApiParams.EMAIL.value to emailId.get().toString(),
        )

        CoroutineScope(Dispatchers.IO).launch {
            val result: ResponseResult<ResponseWrapper<Any>> = getResult {
                apiHelper().forgotPassword(requestData)
            }
            isLoading?.postValue(false)
            response.postValue(result)
        }
    }

}