package com.example.envivoymas.ui.authentication.forgotPassword

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.envivoymas.R
import com.example.envivoymas.ui.authentication.otpVerification.OtpVerification
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.intent

class ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_password)

        changeStatusBarColor(R.color.white)
        val btn=findViewById<Button>(R.id.forgetCode)
        btn.setOnClickListener {
            intent(OtpVerification::class.java, null)
        }

        val btnBack = findViewById<ImageView>(R.id.back)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}