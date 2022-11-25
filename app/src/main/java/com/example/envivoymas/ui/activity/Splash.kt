package com.example.envivoymas.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.envivoymas.R
import com.example.envivoymas.SplashLogin
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.intent

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        changeStatusBarColor(R.color.yellow)
        val handler= Handler(Looper.getMainLooper())
        handler.postDelayed({
            intent(SplashLogin::class.java, null)
            finish()
        },3000)

    }
}