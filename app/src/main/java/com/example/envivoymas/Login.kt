package com.example.envivoymas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.finishActivity
import com.example.envivoymas.utils.intent
import org.w3c.dom.Text

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        changeStatusBarColor(R.color.white)
        val btn=findViewById<TextView>(R.id.textView2)
        btn.setOnClickListener {
            intent(ForgetPassword::class.java, null)
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