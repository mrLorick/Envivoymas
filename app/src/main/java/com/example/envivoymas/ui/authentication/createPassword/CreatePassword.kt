package com.example.envivoymas.ui.authentication.createPassword

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.envivoymas.PasswordChangeSuccessful
import com.example.envivoymas.R
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.finishActivity
import com.example.envivoymas.utils.intent

class CreatePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_password)

        changeStatusBarColor(R.color.white)
        val btn=findViewById<Button>(R.id.resetBtn)
        btn.setOnClickListener {
            intent(PasswordChangeSuccessful::class.java, null)
            finish()
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