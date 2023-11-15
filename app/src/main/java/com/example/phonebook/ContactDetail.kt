package com.example.phonebook

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ContactDetail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        try {
            // Lấy dữ liệu từ Intent
            val avatar = intent.getStringExtra("avatar")
            val name = intent.getStringExtra("name")
            val phoneNumber = intent.getStringExtra("phoneNumber")
            val email = intent.getStringExtra("email")
            val address = intent.getStringExtra("address")

            // Hiển thị thông tin trên màn hình chi tiết
            val avatarTextView: TextView = findViewById(R.id.avatar)
            val nameTextView: TextView = findViewById(R.id.name)
            val phoneNumberTextView: TextView = findViewById(R.id.phonenumber)
            val emailTextView: TextView = findViewById(R.id.email)
            val addressTextView: TextView = findViewById(R.id.address)


            nameTextView.text = "$name"
            avatarTextView.text = "$avatar"
            emailTextView.text = "$email"
            phoneNumberTextView.text = "$phoneNumber"
            addressTextView.text = "$address"

            setResult(Activity.RESULT_OK, intent)
        } catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }
    }
}