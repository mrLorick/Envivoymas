package com.example.envivoymas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.finishActivity
import com.example.envivoymas.utils.intent

class SplashLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_login)

        changeStatusBarColor(R.color.yellow)
        val btn=findViewById<Button>(R.id.loginBtn)
        btn.setOnClickListener {
            intent(Login::class.java, null)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()

    }
}