package com.crowdfunding.agri_fund
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

import com.crowdfunding.dashboard.Dashboard


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.logButton)
        val emailEditText = findViewById<EditText>(R.id.emailLogin)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (isValidEmail(email)) {
                val intent = Intent(this, Dashboard::class.java) // Correct reference to Dashboard activity
                startActivity(intent)
            } else {
                // Show error message for invalid email
                emailEditText.error = "Invalid email address"
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
