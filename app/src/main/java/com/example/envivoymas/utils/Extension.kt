package com.example.envivoymas.utils

import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.envivoymas.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@Suppress("DEPRECATION")
fun Activity.changeStatusBarColor(color: Int? = R.color.white) {
    val window: Window = window
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = ContextCompat.getColor(this, color!!)
}