package com.example.envivoymas.ui.authentication.otpVerification

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.databinding.OtpVerificaionBinding
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.ui.authentication.createPassword.CreatePassword
import com.example.envivoymas.utils.*
import com.example.envivoymas.utils.constant.AppConstant

class OtpVerification : BaseActivity() {
    private var binding: OtpVerificaionBinding? = null
    var viewModel: OtpVerificationViewModel? = null
    var activity = this@OtpVerification

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity, R.layout.otp_verificaion)
        viewModel = ViewModelProvider(activity, ViewModelFactory(activity))[OtpVerificationViewModel::class.java]
        binding!!.viewModel = viewModel
        intView()
    }

    private fun intView() {
        changeStatusBarColor(R.color.white)
        getIntentData()
        setOnClickListener()
        observeDataFromViewModal()
    }

    /** get intent Data
     * Get data From Forgot Password
     * */
    private fun getIntentData() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            viewModel?.emailId?.set(bundle.getString(AppConstant.EMAIL_ID))
        }
    }

    /** Btn click handling*/
    private fun setOnClickListener() {
        binding!!.back.setOnClickListener {
            onBackPressed()
        }

        binding!!.otpView.setOnFinishListener {
            viewModel?.otp?.set(it)
        }

        binding!!.button.setOnClickListener {
            if (viewModel?.otp?.get()!!.isNotBlank()) {
                if (viewModel?.otp?.get()!!.length == 4){
                    viewModel?.otpVerificationApi()
                }else{
                    showErrorBarAlert(activity,getString(R.string.error_response),getString(R.string.please_enter_otp), android.R.drawable.stat_notify_error)
                }
            }else{
                showErrorBarAlert(activity,getString(R.string.error_response),getString(R.string.please_enter_otp), android.R.drawable.stat_notify_error)
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
                            showErrorBarAlert(
                                activity,
                                getString(R.string.error_response),
                                data.message,
                                android.R.drawable.stat_notify_error,
                            )
                        }
                    }
                    is ResponseResult.Error -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.result.errorMsg.toString(),
                            android.R.drawable.stat_notify_error,
                        )
                    }
                    is ResponseResult.FAILURE -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.msg.errorMsg.toString(),
                            android.R.drawable.stat_notify_error,
                        )
                    }
                    is ResponseResult.SessionExpired -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.msg.errorMsg.toString(),
                            android.R.drawable.stat_notify_error,
                        )
                    }
                    else -> showErrorBarAlert(
                        activity,
                        getString(R.string.error_response),
                        resources.getString(R.string.some_thing_went_wrong),
                        android.R.drawable.stat_notify_error,
                    )

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
            showSuccessBarAlert(activity, getString(R.string.success_response), data.message)
            val bundle = bundleOf(AppConstant.EMAIL_ID to viewModel?.emailId?.get().toString())
            intent(CreatePassword::class.java, bundle)
            finishAffinity()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}


