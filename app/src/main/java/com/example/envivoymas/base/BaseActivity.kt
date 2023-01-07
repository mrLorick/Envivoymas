package com.example.envivoymas.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.envivoymas.utils.finishActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding()
    }
    protected abstract fun binding()

    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity()
    }
}