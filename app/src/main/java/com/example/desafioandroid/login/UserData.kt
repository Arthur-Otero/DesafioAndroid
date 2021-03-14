package com.example.desafioandroid.login

import android.util.Log

class UserData{
    private val user = mutableListOf<User>()


    fun addUser(nameInfo: String?, emailInfo: String?, passwordInfo: String?) {
        val userData = User(nameInfo,emailInfo,passwordInfo)
        user.add(userData)
        user.forEach{
            Log.wtf("valores",it.toString())
        }
    }

    fun confirmationEmail(emailInfo: String): User? {
        user.forEach{
            if (it.email.equals(emailInfo)){
                return it
            }
        }
        return null
    }
}