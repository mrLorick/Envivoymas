package com.example.envivoymas.utils.validater

class Validator {

   /* *//** Create Profile screen*//*
    fun createProfileValidator(binding: ActivityCreateProfileBinding, context: Context): Boolean {
        return when {

            binding.cpEmail.text!!.isBlank() && binding.cpEmail.text!!.toString().isValidEmail()-> {
                showToast( context,context.resources.getString(R.string.please_enter_email_id))
                false
            }
            binding.cpPass.text!!.isBlank() -> {
                showToast( context,context.resources.getString(R.string.please_enter_new_password))
                false
            }
            !CommonMethod.isValidPasswordFormat(binding.cpPass.text!!.toString())  -> {
                showToast(context, context.getString(R.string.please_enter_valid_password))
                false
            }
            else -> true
        }
    }*/
}