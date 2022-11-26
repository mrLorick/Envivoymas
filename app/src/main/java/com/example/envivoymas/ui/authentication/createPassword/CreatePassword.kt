package com.example.envivoymas.ui.authentication.createPassword

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.PasswordChangeSuccessful
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.base.BaseResponse
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.databinding.ResetPasswordBinding
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.utils.*
import com.example.envivoymas.utils.constant.AppConstant

class CreatePassword : BaseActivity() {
    private var binding : ResetPasswordBinding? = null
    var viewModel : CreatePasswordViewModel? = null
    var activity = this@CreatePassword

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity,R.layout.reset_password)
        viewModel = ViewModelProvider(activity, ViewModelFactory(activity))[CreatePasswordViewModel::class.java]
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
     * Get data From Otp verification
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

        binding!!.resetBtn.setOnClickListener {
            if (AppConstant.validator.createPasswordValidation(activity,binding!!, this)) {
                if (viewModel?.newPassword?.get().toString() == viewModel?.confirmPassword?.get().toString()){
                    viewModel?.createPasswordApi()
                }else{
                    showErrorBarAlert(activity,getString(R.string.error_response),getString(R.string.please_do_not_match_password), android.R.drawable.stat_notify_error)
                }
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
                            showErrorBarAlert(activity,getString(R.string.error_response),data.message, android.R.drawable.stat_notify_error)
                        }
                    }
                    is ResponseResult.Error -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.result.errorMsg.toString(), android.R.drawable.stat_notify_error)
                    }
                    is ResponseResult.FAILURE -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.msg.errorMsg.toString(), android.R.drawable.stat_notify_error)
                    }
                    is ResponseResult.SessionExpired -> {
                        showErrorBarAlert(activity,getString(R.string.error_response),it.msg.errorMsg.toString(), android.R.drawable.stat_notify_error)
                    }
                    else -> showErrorBarAlert(activity,getString(R.string.error_response),resources.getString(R.string.some_thing_went_wrong), android.R.drawable.stat_notify_error)

                }
            }


            isLoading?.observe(activity) {
                if (it) {
                    showProgress(activity)
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
            intent(PasswordChangeSuccessful::class.java,null)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}