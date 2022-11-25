package com.example.envivoymas.ui.authentication.otpVerification

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.envivoymas.R
import com.example.envivoymas.ui.authentication.createPassword.CreatePassword
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.finishActivity
import com.example.envivoymas.utils.intent

class OtpVerification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_verificaion)

        changeStatusBarColor(R.color.white)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            intent(CreatePassword::class.java, null)
        }

        val btnBack = findViewById<ImageView>(R.id.back)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}