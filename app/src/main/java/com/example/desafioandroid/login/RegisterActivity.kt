package com.example.desafioandroid.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.desafioandroid.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    private val buttonRegister by lazy { findViewById<Button>(R.id.buttonRegisterDone) }
    private val name by lazy { findViewById<TextInputEditText>(R.id.nameRegister) }
    private val email by lazy { findViewById<TextInputEditText>(R.id.emailRegister) }
    private val password by lazy { findViewById<TextInputEditText>(R.id.passwordRegister) }
    private val repeatPassword by lazy { findViewById<TextInputEditText>(R.id.passwordConfirmationRegister) }
    private val toolbar by lazy { findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar2) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        buttonRegister.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NAME", name.text.toString())
            intent.putExtra("EMAIL", email.text.toString())
            intent.putExtra("PASSWORD", password.text.toString())
            startActivity(intent)
        }
    }
}