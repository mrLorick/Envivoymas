package com.example.envivoymas.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.envivoymas.R

fun <T> Activity.intent(destination: Class<T>, bundle: Bundle?) {
    val intent = Intent(this, destination)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
}

fun Activity.finishActivity(){
    finish()
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
}