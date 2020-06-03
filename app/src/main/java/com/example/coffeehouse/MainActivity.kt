package com.example.coffeehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var btnlogin: Button
    val validmobilenumer = "7868941282"
    val validpassword = "raj@123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Coffee House"
        btnlogin = findViewById(R.id.btnLogin)
        txtForgotPassword.setOnClickListener {
            val intent = Intent(this, forgot::class.java)
            startActivity(intent)
        }
        txtSignupNow.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            val mobilenumber = etmobile.text.toString()
            val password = etPassword.text.toString()
            if (mobilenumber == validmobilenumer && password == validpassword) {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "error",
                    Toast.LENGTH_SHORT
                ).show();

            }
        }
    }
}




