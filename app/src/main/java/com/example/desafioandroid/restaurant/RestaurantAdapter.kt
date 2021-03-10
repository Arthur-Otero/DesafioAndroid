package com.example.desafioandroid.restaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.menu.MenuActivity

class RestaurantAdapter(val restaurants: MutableList<RestaurantItens>) : RecyclerView.Adapter<RestaurantAdapter.MenuViewHolder>() {

    override fun getItemCount(): Int = restaurants.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item,parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.address.text = restaurants[position].address
        holder.time.text = restaurants[position].time
        holder.restaurantName.text = restaurants[position].name
        holder.screen.setImageResource(restaurants[position].image)

        holder.cardView.setOnClickListener{
            val intent = Intent(it.context, MenuActivity::class.java)
            intent.putExtra("NAME", restaurants[position].name)
            intent.putExtra("IMAGE", restaurants[position].image)
            it.context.startActivity(intent)
        }
    }

    inner class MenuViewHolder(view:View): RecyclerView.ViewHolder(view){
        val cardView by lazy { view.findViewById<CardView>(R.id.restaurantCard) }
        val screen by lazy { view.findViewById<ImageView>(R.id.menu_screen) }
        val restaurantName by lazy { view.findViewById<TextView>(R.id.dish_name) }
        val address by lazy { view.findViewById<TextView>(R.id.address) }
        val time by lazy { view.findViewById<TextView>(R.id.time) }
    }
}