package com.example.envivoymas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.intent

class PasswordChangeSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_change)
        changeStatusBarColor(R.color.white)
    }
}