package com.example.envivoymas.ui.authentication.forgotPassword

import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.databinding.ForgetPasswordBinding
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.ui.authentication.otpVerification.OtpVerification
import com.example.envivoymas.utils.*
import com.example.envivoymas.utils.constant.AppConstant

class ForgetPassword : BaseActivity() {
    private var binding : ForgetPasswordBinding? = null
    var viewModel : ForgotViewModel? = null
    var activity = this@ForgetPassword

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity,R.layout.forget_password)
        viewModel = ViewModelProvider(activity, ViewModelFactory(activity))[ForgotViewModel::class.java]
        binding!!.viewModel = viewModel
        intView()
    }

    private fun intView() {
        changeStatusBarColor(R.color.white)
        setOnClickListener()
        observeDataFromViewModal()
    }

    /** Btn click handling*/
    private fun setOnClickListener() {
        binding!!.back.setOnClickListener {
            onBackPressed()
        }

        binding!!.forgetCode.setOnClickListener {
            if (AppConstant.validator.forgotPasswordValidation(activity,binding!!, this)) {
                viewModel?.forgotPasswordApi()
            }
        }
    }


    /** Observer Response via View model*/
    private fun observeDataFromViewModal() {
        viewModel?.apply {
            response.observe(activity) {
                when (it) {
                    is ResponseResult.Success -> {
                        val data = it.result.data as BaseResponse
                        if (data.status == 1) {
                            apiSuccessResponse(data)
                        } else {
                            showErrorBarAlert(activity,getString(R.string.error_response),data.message, android.R.drawable.stat_notify_error,)
                        }
                    }
                    is ResponseResult.Error -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.result.errorMsg.toString(), android.R.drawable.stat_notify_error,)
                    }
                    is ResponseResult.FAILURE -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.msg.errorMsg.toString(), android.R.drawable.stat_notify_error,)
                    }
                    is ResponseResult.SessionExpired -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.msg.errorMsg.toString(), android.R.drawable.stat_notify_error,)
                    }
                    else -> showErrorBarAlert(activity,getString(R.string.error_response),resources.getString(R.string.some_thing_went_wrong), android.R.drawable.stat_notify_error,)

                }
            }


            isLoading?.observe(activity) {
                if (it) {
                    showProgress(context)
                } else {
                    hideProgress()
                }
            }
        }
    }

    /** Login Api success response*/
    private fun apiSuccessResponse(data: BaseResponse) {
        try {
            showSuccessBarAlert(activity,getString(R.string.success_response),data.message)
            val bundle = bundleOf(AppConstant.EMAIL_ID to viewModel?.emailId?.get().toString())
            intent(OtpVerification::class.java, bundle)

        }catch (e:Exception){
            e.printStackTrace()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}