package com.application.chatapp.model

data class User(
    val name : String,
    val profileImageUrl : String,
    val email : String,
    val bio : String,
    val gender: Gender,
    val dateOfBirth : String,
)
