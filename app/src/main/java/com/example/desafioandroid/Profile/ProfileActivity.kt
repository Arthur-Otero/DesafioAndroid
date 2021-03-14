package com.example.desafioandroid.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.desafioandroid.R
import com.example.desafioandroid.SingletonProfile

class ProfileActivity : AppCompatActivity() {
    private val nameProfile by lazy { findViewById<TextView>(R.id.nameProfile) }
    private val emailProfile by lazy { findViewById<TextView>(R.id.emailProfile) }
    private val toolbar by lazy { findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarProfile) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val singleton = SingletonProfile

        nameProfile.text = singleton.nameProfile
        emailProfile.text = singleton.emailProfile
    }
}