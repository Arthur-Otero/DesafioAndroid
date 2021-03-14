package com.example.desafioandroid.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.Profile.ProfileActivity
import com.example.desafioandroid.R

class RestaurantActivity : AppCompatActivity() {
    private val menu by lazy { findViewById<RecyclerView>(R.id.menu_itens) }
    val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    private val floatButton by lazy { findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        floatButton.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val restaurant = getRestaurant()

        menu.layoutManager = LinearLayoutManager(this)
        val adapter = RestaurantAdapter(restaurant)
        menu.adapter = adapter
    }

    private fun getRestaurant() : MutableList<RestaurantItens> {
        val restaurantList = mutableListOf<RestaurantItens>()
        restaurantList.add(RestaurantItens("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00",R.drawable.raster))
        restaurantList.add(RestaurantItens("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema","Fecha às 00:00",R.drawable.raster))
        restaurantList.add(RestaurantItens("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo","Fecha às 00:00",R.drawable.raster))
        restaurantList.add(RestaurantItens("Sí Señor!", "Alameda Jauaperi, 626 - Moema","Fecha às 01:00",R.drawable.raster))
        return restaurantList
    }
}
