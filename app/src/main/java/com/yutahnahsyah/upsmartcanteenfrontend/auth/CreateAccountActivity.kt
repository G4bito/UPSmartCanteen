package com.yutahnahsyah.upsmartcanteenfrontend.auth

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.yutahnahsyah.upsmartcanteenfrontend.MainActivity
import com.yutahnahsyah.upsmartcanteenfrontend.R

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        // These IDs MUST match the android:id in the XML above
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val name = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Logic to check if fields are valid
            if (validateInput(name, email, password)) {
                Toast.makeText(this, "Welcome, $name!", Toast.LENGTH_SHORT).show()

                // Go to Main Activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }        }

        tvLogin.setOnClickListener {
            // Closes this screen and goes back to Login
            finish()
        }
    }

    private fun validateInput(name: String, email: String, password: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }

        // Domain Validation for Phinmaed or Gmail
        val emailLower = email.lowercase()
        val isValidDomain = emailLower.endsWith("@phinmaed.com") ||
                emailLower.endsWith("@gmail.com")

        if (!isValidDomain) {
            Toast.makeText(this, "Use PhinmaEd or Gmail account", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
