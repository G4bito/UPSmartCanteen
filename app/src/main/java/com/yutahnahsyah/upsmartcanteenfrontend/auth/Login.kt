package com.yutahnahsyah.upsmartcanteenfrontend.auth

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.yutahnahsyah.upsmartcanteenfrontend.BaseActivity
import com.yutahnahsyah.upsmartcanteenfrontend.MainActivity
import com.yutahnahsyah.upsmartcanteenfrontend.R

class Login : BaseActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<EditText>(R.id.emailEditText)
        val passwordField = findViewById<EditText>(R.id.passwordEditText)
        val loginBtn = findViewById<Button>(R.id.loginButton)
        val togglePasswordBtn = findViewById<ImageButton>(R.id.togglePasswordVisibility)

        togglePasswordBtn.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordField.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePasswordBtn.setImageResource(R.drawable.ic_eye_on)
            } else {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePasswordBtn.setImageResource(R.drawable.ic_eye_off)
            }
            // Move cursor to the end of the text
            passwordField.setSelection(passwordField.text.length)
        }

        loginBtn.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this@Login, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
