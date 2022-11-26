package com.example.envivoymas.utils.constant

object ApiConstant {
    const val GOOGLE_MAP_KEY = "AIzaSyB6Z2qQ5Pcz8juRI-EXVX2ktVwwKKZ1fVw"
    const val BASE_URL = "http://20.228.178.181:8080/api/"
    const val EMPLOYEE_LOGIN = "employee/auth/login"
    const val FORGOT_PASSWORD = "employee/auth/generateOTPEmail"
    const val OTP_VERIFICATION = "employee/auth/verifyOTP"
    const val CREATE_PASSWORD = "employee/auth/resetPassword"


    enum class ApiParams(val value: String) {
        EMAIL("email"),
        PASSWORD("password"),
        OTP("otp"),
    }

}