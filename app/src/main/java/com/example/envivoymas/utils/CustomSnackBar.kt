package com.example.envivoymas.utils

import android.app.Activity
import com.example.envivoymas.R
import org.aviran.cookiebar2.CookieBar


fun showBarAlert(activity: Activity?, title: String?, message: String?, icon: Int, gravity: Int) {
    CookieBar.build(activity)
        .setTitle(title)
        .setTitleColor(R.color.white)
        .setBackgroundColor(R.color.yellow)
        .setIcon(icon)
        .setCookiePosition(gravity)
        .setMessage(message)
        .setMessageColor(R.color.white)
        .setDuration(3000) // 3 seconds
        .show()
}

fun showErrorBarAlert(activity: Activity?, title: String?, message: String?, icon: Int) {
    CookieBar.build(activity)
        .setTitle(title)
        .setTitleColor(R.color.white)
        .setBackgroundColor(R.color.red_error)
        .setIcon(icon)
        .setCookiePosition(CookieBar.TOP)
        .setMessage(message)
        .setMessageColor(R.color.white)
        .setDuration(3000) // 3 seconds
        .show()
}

fun showSuccessBarAlert(activity: Activity?, title: String?, message: String?) {
    CookieBar.build(activity)
        .setTitle(title)
        .setTitleColor(R.color.white)
        .setBackgroundColor(R.color.yellow)
        .setCookiePosition(CookieBar.TOP)
        .setMessage(message)
        .setMessageColor(R.color.white)
        .setDuration(3000) // 3 seconds
        .show()
}