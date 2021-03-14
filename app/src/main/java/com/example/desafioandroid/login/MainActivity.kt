package com.example.desafioandroid.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.desafioandroid.R
import com.example.desafioandroid.SingletonProfile
import com.example.desafioandroid.restaurant.RestaurantActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val logInButton by lazy { findViewById<Button>(R.id.buttonLogIn) }
    private val registerButton by lazy { findViewById<Button>(R.id.buttonRegister) }
    private val email by lazy { findViewById<TextInputEditText>(R.id.emailText) }
    private val password by lazy { findViewById<TextInputEditText>(R.id.password) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        registerButton.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        logInButton.setOnClickListener {
            if (buttonClick()) {
                val intent = Intent(this, RestaurantActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun buttonClick(): Boolean {
        val extras = intent.extras
        val nameExtras = extras?.getString("NAME")
        val emailExtras = extras?.getString("EMAIL")
        val passwordExtras = extras?.getString("PASSWORD")

        val userData = UserData()
        userData.addUser(nameExtras, passwordExtras, emailExtras)

        val emailError = email.text.toString()
        val passwordError = password.text.toString()

        val user = userData.confirmationEmail(emailError)

        when {
            emailError.isBlank() && passwordError.isBlank() -> {
                email?.error = "Email incorreto"
                password?.error = "Senha invalida"
                return false
            }
            emailError.isBlank() || user == null -> {
                email?.error = "Email incorreto"
                password?.error = null
                return false
            }
            user.password != passwordError || passwordError.isBlank() -> {
                email?.error = null
                password?.error = "Senha invalida"
                return false
            }
            else -> {
                val singleton = SingletonProfile
                singleton.nameProfile = "NOME: " + user.nome
                singleton.emailProfile = "EMAIL: " + user.email
                return true
            }
        }
    }
}