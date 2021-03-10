package com.example.desafioandroid.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.desafioandroid.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    private val buttonRegister by lazy { findViewById<Button>(R.id.buttonRegisterDone) }
    private val name by lazy { findViewById<TextInputEditText>(R.id.nameRegister) }
    private val email by lazy { findViewById<TextInputEditText>(R.id.emailRegister) }
    private val password by lazy { findViewById<TextInputEditText>(R.id.passwordRegister) }
    private val repeatPassword by lazy { findViewById<TextInputEditText>(R.id.passwordConfirmationRegister) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonRegister.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NAME", name.text.toString())
            intent.putExtra("EMAIL", email.text.toString())
            intent.putExtra("PASSWORD", password.text.toString())
            startActivity(intent)
        }
    }

    /*private fun infosConfirmation() {
        when{
            name.text.isNullOrBlank() -> name.error = "Digite um nome"
            email.text.isNullOrBlank() -> email.error = "Digite um email"
            password.text.isNullOrBlank() && password.text?.length!! >= 8 -> password.error = "Digite uma senha com mais de 6 caracteres"
            repeatPassword.text.isNullOrBlank() && repeatPassword.text == password.text && password.text?.length!! >= 8 -> password.error = "A senha tem que ser igual a anterior"
            else -> buttonRegister.setOnClickListener(){
                val user = UserData()
                user.addUser(name.text.toString(),email.text.toString(),password.text.toString())
                onBackPressed()
            }
        }

    }*/
}