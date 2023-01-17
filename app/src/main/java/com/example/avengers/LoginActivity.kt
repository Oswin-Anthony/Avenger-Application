package com.example.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etMobileNumber : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    private val validMobileNumber = "0123456789"
    private val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Login"

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if(isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            val nameOfAvenger : String

            if(mobileNumber == validMobileNumber) {
                val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
                when(password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Iron Man"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[1] -> {
                        nameOfAvenger = "Captain America"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[2] -> {
                        nameOfAvenger = "Hulk"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[3] -> {
                        nameOfAvenger = "The Avengers"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    else -> {
                        Toast
                            .makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            } else {
                Toast
                    .makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun savePreferences(title : String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("title", title).apply()
    }
}