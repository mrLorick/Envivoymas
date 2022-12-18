package com.example.envivoymas.ui.authentication.login

import android.text.InputType
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.databinding.ActivityLoginBinding
import com.example.envivoymas.model.LoginResponse
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.ui.activity.admin.dashboard.AdminDashboard
import com.example.envivoymas.ui.authentication.forgotPassword.ForgetPassword
import com.example.envivoymas.utils.*
import com.example.envivoymas.utils.constant.AppConstant.validator


class LoginActivity : BaseActivity() {
    var binding : ActivityLoginBinding? = null
    var viewModel : LoginViewModel? = null
    var activity = this@LoginActivity
    private var isPasswordShow = true

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity,R.layout.activity_login)
        viewModel =ViewModelProvider(activity, ViewModelFactory(activity))[LoginViewModel::class.java]
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

        binding!!.eye.setOnClickListener {
            if (isPasswordShow){
                isPasswordShow = !isPasswordShow
                binding!!.enterPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{
                isPasswordShow = !isPasswordShow
                binding!!.enterPassword.inputType =  InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        binding!!.btnLogin.setOnClickListener {
            intent(AdminDashboard::class.java,null)
            if (validator.loginValidation(activity,binding!!, this)) {
                viewModel?.loginApi()
            }
        }

        binding!!.textView2.setOnClickListener {
            intent(ForgetPassword::class.java,null)
        }
    }


    /** Observer Response via View model*/
    private fun observeDataFromViewModal() {
        viewModel?.apply {
            response.observe(activity) {
                when (it) {
                    is ResponseResult.Success -> {
                        val data = it.result.data as LoginResponse
                        if (data.status == 1) {
                            apiSuccessResponse(data)
                        } else {
                            showErrorBarAlert(
                                activity,
                                getString(R.string.error_response),
                                data.message,
                                android.R.drawable.stat_notify_error
                            )
                        }
                    }
                    is ResponseResult.Error -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.result.errorMsg.toString(),
                            android.R.drawable.stat_notify_error
                        )
                    }
                    is ResponseResult.FAILURE -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.msg.errorMsg.toString(),
                            android.R.drawable.stat_notify_error
                        )
                    }
                    is ResponseResult.SessionExpired -> {
                        showErrorBarAlert(
                            activity,
                            getString(R.string.error_response),
                            it.msg.errorMsg.toString(),
                            android.R.drawable.stat_notify_error
                        )
                    }
                    else -> showErrorBarAlert(
                        activity,
                        getString(R.string.error_response),
                        resources.getString(R.string.some_thing_went_wrong),
                        android.R.drawable.stat_notify_error
                    )

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
    private fun apiSuccessResponse(data: LoginResponse) {
        try {
            intent(AdminDashboard::class.java,null)
            showSuccessBarAlert(activity,getString(R.string.success_response),data.message)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}