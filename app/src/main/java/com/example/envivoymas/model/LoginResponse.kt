package com.example.envivoymas.model

class LoginResponse(
    var status : Int? = 0,
    var message : String? = "",
    var account : AccountModel? =null
)

data class AccountModel(
    var employeeID : Int?= null,
    var employeeCode : String?= "",
    var name : String?= "",
    var phone : String?= "",
    var email : String?= "",
    var isActive : Boolean?= null,
    var companyName : String?= "",
    var token : String?= "",
    var refreshToken : String?= "",
)
