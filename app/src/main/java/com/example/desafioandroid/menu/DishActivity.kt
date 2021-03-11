package com.example.desafioandroid.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R

class DishActivity : AppCompatActivity() {
    private val dishImage by lazy { findViewById<ImageView>(R.id.dishImage) }
    private val dishName by lazy { findViewById<TextView>(R.id.dishName) }
    private val dishDescription by lazy { findViewById<TextView>(R.id.dishDescription) }
    private val toolbar by lazy { findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_dish) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val extras = intent.extras
        val name = extras?.getString("DISHNAME")
        val descriptionDish = extras?.getString("DISHDESCRIPTION")
        val imageSrc = extras?.getInt("DISHIMAGE")

        if (name != null && descriptionDish !=null && imageSrc!= null){
            dishName.text = name
            dishDescription.text = descriptionDish
            dishImage.setImageResource(imageSrc)
        }else{
            Toast.makeText(this,"Error ao encontrar valores",Toast.LENGTH_LONG).show()
            finish()
        }
    }
}