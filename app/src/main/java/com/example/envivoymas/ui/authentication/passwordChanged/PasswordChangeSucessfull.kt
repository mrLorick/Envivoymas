package com.example.envivoymas.ui.authentication.passwordChanged

import androidx.databinding.DataBindingUtil
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.databinding.PasswordChangeBinding
import com.example.envivoymas.ui.authentication.login.LoginActivity
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.intent

class PasswordChangeSuccessful : BaseActivity() {
    private var binding : PasswordChangeBinding? = null
    var activity = this@PasswordChangeSuccessful

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity, R.layout.password_change)
        intView()
    }

    private fun intView() {
        changeStatusBarColor(R.color.white)
        setOnClickListener()
    }

    /** Btn click handling*/
    private fun setOnClickListener() {
        binding!!.goToLogin.setOnClickListener {
            intent(LoginActivity::class.java,null)
        }
    }
}