package com.example.envivoymas.ui.authentication.createPassword

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

class CreatePasswordViewModel(activity: Activity) : BaseViewModel(activity){
    var emailId = ObservableField("")
    var newPassword = ObservableField("")
    var confirmPassword = ObservableField("")

    /** this function for hit create password Api*/
    fun createPasswordApi() {
        isLoading?.postValue(true)
        val requestData = hashMapOf(
            ApiConstant.ApiParams.EMAIL.value to emailId.get().toString(),
            ApiConstant.ApiParams.PASSWORD.value to newPassword.get().toString(),
        )

        CoroutineScope(Dispatchers.IO).launch {
            val result: ResponseResult<ResponseWrapper<Any>> = getResult {
                apiHelper().createPassword(requestData)
            }
            isLoading?.postValue(false)
            response.postValue(result)
        }
    }
}