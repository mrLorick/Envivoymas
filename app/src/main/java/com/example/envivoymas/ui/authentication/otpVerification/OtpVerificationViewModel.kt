package com.example.envivoymas.ui.authentication.otpVerification

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

class OtpVerificationViewModel(activity: Activity) : BaseViewModel(activity){
    var emailId = ObservableField("")
    var otp = ObservableField("")

    /** this function for hit otp verification password Api*/
    fun otpVerificationApi() {
        isLoading?.postValue(true)
        val requestData = hashMapOf(
            ApiConstant.ApiParams.EMAIL.value to emailId.get().toString(),
            ApiConstant.ApiParams.OTP.value to otp.get().toString(),
        )

        CoroutineScope(Dispatchers.IO).launch {
            val result: ResponseResult<ResponseWrapper<Any>> = getResult {
                apiHelper().otpVerification(requestData)
            }
            isLoading?.postValue(false)
            response.postValue(result)
        }
    }

}