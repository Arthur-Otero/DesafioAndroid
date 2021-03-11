package com.example.desafioandroid.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R

class MenuActivity : AppCompatActivity() {
    private val image by lazy { findViewById<ImageView>(R.id.restaurantImage) }
    private val name by lazy { findViewById<TextView>(R.id.restaurantName) }
    private val menu by lazy { findViewById<RecyclerView>(R.id.courses) }
    private val toolbar by lazy { findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val extras = intent.extras
        val imageSrc = extras?.getInt("IMAGE")
        val restaurantName = extras?.getString("NAME")

        if (imageSrc!=null && restaurantName!=null) {
            image.setImageResource(imageSrc)
            name.text = restaurantName
        }

        menu.layoutManager = GridLayoutManager(this,2)
        val adapter = MenuAdapter(getItens())
        menu.adapter = adapter
    }

    private fun getItens() : MutableList<MenuItens> {
        val text = "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        val itensList = mutableListOf<MenuItens>()
        itensList.add(MenuItens("Macarão com alho", text,R.drawable.raster))
        itensList.add(MenuItens("Miojão", text,R.drawable.raster))
        itensList.add(MenuItens("Lasanha", text,R.drawable.raster))
        itensList.add(MenuItens("Macarrona", text,R.drawable.raster))
        itensList.add(MenuItens("Pavê", text,R.drawable.raster))
        itensList.add(MenuItens("Bife acebolado", text,R.drawable.raster))
        return itensList
    }
}