package com.example.desafioandroid.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R

class MenuActivity : AppCompatActivity() {
    val image by lazy { findViewById<ImageView>(R.id.restaurantImage) }
    val name by lazy { findViewById<TextView>(R.id.restaurantName) }
    val menu by lazy { findViewById<RecyclerView>(R.id.courses) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

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
        val itensList = mutableListOf<MenuItens>()
        itensList.add(MenuItens("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema",R.drawable.raster))
        itensList.add(MenuItens("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Sí Señor!", "Alameda Jauaperi, 626 - Moema",R.drawable.raster))
        itensList.add(MenuItens("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema",R.drawable.raster))
        itensList.add(MenuItens("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Sí Señor!", "Alameda Jauaperi, 626 - Moema",R.drawable.raster))
        itensList.add(MenuItens("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema",R.drawable.raster))
        itensList.add(MenuItens("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo",R.drawable.raster))
        itensList.add(MenuItens("Sí Señor!", "Alameda Jauaperi, 626 - Moema",R.drawable.raster))
        return itensList
    }
}