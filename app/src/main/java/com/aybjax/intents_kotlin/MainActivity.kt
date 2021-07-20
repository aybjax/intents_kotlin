package com.aybjax.intents_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val FULL_NAME_KEY = "FULL_NAME_KEY"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submit_button).setOnClickListener {
            val full_name = findViewById<EditText>(R.id.full_name)
                .text.toString().trim()

            if(full_name.isNotEmpty()) {
                Intent(this, WelcomeActivity::class.java)
                    .also { welcome_intent ->
                        welcome_intent.putExtra(FULL_NAME_KEY, full_name)

                        startActivity(welcome_intent)
                    }
            }
            else {
                Toast.makeText(this, getString(R.string.full_name_label), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}