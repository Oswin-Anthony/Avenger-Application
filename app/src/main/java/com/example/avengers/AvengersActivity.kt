package com.example.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvengersActivity : AppCompatActivity() {
    private lateinit var name : String
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var btnLogout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        name = sharedPreferences.getString("title", "The Avengers").toString()
        title = name

        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener{
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            Toast
                .makeText(this@AvengersActivity, "Logged Out", Toast.LENGTH_SHORT)
                .show()
            finish()
        }
    }
}