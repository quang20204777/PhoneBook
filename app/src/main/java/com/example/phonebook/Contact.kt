package com.example.phonebook

data class Contact(
    val id : Int,
    val avatar: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val address: String,
)