package com.example.envivoymas.ui.authentication.login

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.databinding.ActivityLoginBinding
import com.example.envivoymas.model.LoginResponse
import com.example.envivoymas.retrofit.ResponseResult
import com.example.envivoymas.utils.CommonMethod.showToast
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.finishActivity
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.ui.authentication.forgotPassword.ForgetPassword
import com.example.envivoymas.utils.intent

class LoginActivity : BaseActivity() {
    var binding : ActivityLoginBinding? = null
    var viewModel : LoginViewModel? = null
    var activity = this@LoginActivity

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

        binding!!.btnLogin.setOnClickListener {
            viewModel?.loginApi()
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
                            showToast(activity, data.message!!)
                        }
                    }
                    is ResponseResult.Error -> {
                        showToast(activity, it.result.errorMsg as String)
                    }
                    is ResponseResult.FAILURE -> {
                        showToast(activity, it.msg.errorMsg.toString())
                    }
                    is ResponseResult.SessionExpired -> {
                        showToast(activity, it.msg.errorMsg as String)
                    }
                    else -> showToast(activity, resources.getString(R.string.some_thing_went_wrong))
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
        showToast(activity, data.message.toString())
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}