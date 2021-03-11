package com.example.desafioandroid.menu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.restaurant.RestaurantActivity

class MenuAdapter(val menuItens: MutableList<MenuItens>):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.dishName.text = menuItens[position].name
        holder.dishImage.setImageResource(menuItens[position].image)

        holder.menuCard.setOnClickListener{
            val intent = Intent(it.context, DishActivity::class.java)
            intent.putExtra("DISHNAME", menuItens[position].name)
            intent.putExtra("DISHIMAGE",menuItens[position].image)
            intent.putExtra("DISHDESCRIPTION",menuItens[position].description)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = menuItens.size

    inner class MenuViewHolder(view: View):RecyclerView.ViewHolder(view){
        val menuCard by lazy { view.findViewById<CardView>(R.id.menu_card) }
        val dishImage by lazy { view.findViewById<ImageView>(R.id.course_screen) }
        val dishName by lazy { view.findViewById<TextView>(R.id.course_name) }
    }
}