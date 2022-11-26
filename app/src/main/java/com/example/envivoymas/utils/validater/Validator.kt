package com.example.envivoymas.utils.validater

import android.app.Activity
import android.content.Context
import com.example.envivoymas.R
import com.example.envivoymas.databinding.ActivityLoginBinding
import com.example.envivoymas.databinding.ForgetPasswordBinding
import com.example.envivoymas.databinding.ResetPasswordBinding
import com.example.envivoymas.utils.CommonMethod
import com.example.envivoymas.utils.CommonMethod.isValidEmail
import com.example.envivoymas.utils.showErrorBarAlert

class Validator {

    /** Login Validation*/
    fun loginValidation(activity: Activity, binding: ActivityLoginBinding, context: Context): Boolean {
        return when {
            binding.user.text!!.isBlank()-> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_email), android.R.drawable.stat_notify_error,)
                false
            }
            !binding.user.text!!.toString().isValidEmail()-> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_valid_email), android.R.drawable.stat_notify_error,)
                false
            }

            binding.enterPassword.text!!.isBlank() -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_password), android.R.drawable.stat_notify_error,)
                false
            }
            !CommonMethod.isValidPasswordFormat(binding.enterPassword.text!!.toString())  -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_valid_password), android.R.drawable.stat_notify_error,)
                false
            }
            else -> true
        }
    }

    /** Forgot Password Validation*/
    fun forgotPasswordValidation(activity: Activity, binding: ForgetPasswordBinding, context: Context): Boolean {
        return when {
            binding.email.text!!.isBlank()-> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_email), android.R.drawable.stat_notify_error,)
                false
            }
            !binding.email.text!!.toString().isValidEmail()-> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_valid_email), android.R.drawable.stat_notify_error,)
                false
            }
            else -> true
        }
    }

    /** create Password Validation*/
    fun createPasswordValidation(activity: Activity, binding: ResetPasswordBinding, context: Context): Boolean {
        return when {
            binding.user.text!!.isBlank() -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_new_password), android.R.drawable.stat_notify_error,)
                false
            }
            !CommonMethod.isValidPasswordFormat(binding.user.text!!.toString())  -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_new_valid_password), android.R.drawable.stat_notify_error,)
                false
            }

            binding.confirmPassword.text!!.isBlank() -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_confirm_password), android.R.drawable.stat_notify_error,)
                false
            }
            !CommonMethod.isValidPasswordFormat(binding.confirmPassword.text!!.toString())  -> {
                showErrorBarAlert(activity,context.resources.getString(R.string.error_response),context.resources.getString(R.string.please_enter_confirm_valid_password), android.R.drawable.stat_notify_error,)
                false
            }
            else -> true
        }
    }

}