package com.example.envivoymas.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.*
import android.location.Geocoder
import android.provider.Settings
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.example.envivoymas.R
import java.lang.StringBuilder
import java.util.*
import java.util.regex.Pattern


object CommonMethod {

    private var progressDialog: Dialog? = null

    //todo show progress
    fun showProgress(context: Context) {
        try {
            if (!isShowProgress()) {
                    progressDialog = Dialog(context, R.style.progressBarDialog)
                    progressDialog?.setContentView(R.layout.progress_dialog)
                    progressDialog?.setCanceledOnTouchOutside(false)
                    progressDialog?.setCancelable(false)
                    progressDialog?.show()
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }

    }

    //todo hide progress
    fun hideProgress() {
        try {
            if (progressDialog != null && progressDialog!!.isShowing) {
                progressDialog?.cancel()
            }
        } catch (i: IllegalArgumentException) {
            i.printStackTrace()
        }

    }

    //todo check progress bar is showing
    private fun isShowProgress(): Boolean {
        return progressDialog != null && progressDialog!!.isShowing
    }

    @SuppressLint("HardwareIds")
    fun getDeviceToken(contentResolver: ContentResolver): String {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

//    fun getFireBaseToken() {
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
//                FirebaseInstallations.getInstance().id.addOnSuccessListener {
//                    val token =  it
//                    PreferenceUtil.get().set(PreferenceUtil.FIREBASE_TOKEN, token)
//                }
//
//                return@OnCompleteListener
//            }
//            // Get new FCM registration token
//            val token = task.result
//            PreferenceUtil.get().set(PreferenceUtil.FIREBASE_TOKEN, token)
//
//        })
//
//    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    fun updateTime(hour: Int, mins: Int): String {
        var hours = hour
        var timeSet = ""
        when {
            hours > 12 -> {
                hours -= 12
                timeSet = "PM"
            }
            hours == 0 -> {
                hours += 12
                timeSet = "AM"
            }
            hours == 12 -> timeSet = "PM"
            else -> timeSet = "AM"
        }
        var minutes = ""
        minutes = if (mins < 10) "0$mins" else mins.toString()

        return StringBuilder().append(hours).append(':').append(minutes).append(" ").append(timeSet).toString()
    }


    fun copyText(context: Context, code: String) {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("Label", code)
        clipboardManager.setPrimaryClip(clipData)
        showToast(context, "Copied code to clipboard")
    }

    fun getCityName(context: Context, latitude: Double, longitude: Double): String {
        val geoCoder = Geocoder(context, Locale.getDefault())
        val addresses = geoCoder.getFromLocation(latitude, longitude, 1)
        return addresses[0].getAddressLine(0)
    }

    fun hideKeyboard(activity: Activity, editText: EditText?) {
        val imm: InputMethodManager? = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(editText?.windowToken, 0)
    }

    fun showKeyBoard(activity: Activity, editText: EditText?) {
        editText?.requestFocus()
        val imm: InputMethodManager? = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    fun String.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z0-9])" +      //any letter
                    "(?=.*[@#$%^&+='!?:;~<`.>*/()-])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{5,20}" +               //at least 8 characters
                    "$"
        )
        return passwordREGEX.matcher(password).matches()
    }

     fun showCustomUI(activity: Activity) {
        val decorView: View = activity.window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

}