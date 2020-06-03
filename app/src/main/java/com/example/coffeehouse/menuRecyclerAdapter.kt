package com.example.coffeehouse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeehouse.model.coffee

class menuRecyclerAdapter (val context:Context,val itemList:ArrayList<coffee>) :RecyclerView.Adapter<menuRecyclerAdapter.MenuViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclermenu_single_row,parent,false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val coffee=itemList[position]
        holder.textcoffeeName.text=coffee.coffeeName
        holder.textCoffeePrice.text=coffee.price
        holder.textcoffeeRating.text=coffee.ratings
        holder.imgCoffee.setImageResource(coffee.img)
        holder.llMenu.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.textcoffeeName.text}",Toast.LENGTH_SHORT).show()
        }
    }
    class MenuViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textcoffeeName:TextView=view.findViewById(R.id.txtCoffeeName)
        val textCoffeePrice:TextView=view.findViewById(R.id.txtCoffeePrice)
        val textcoffeeRating:TextView=view.findViewById(R.id.txtCoffeeRating)
        val imgCoffee:ImageView=view.findViewById(R.id.imgCoffeeImage)
        val llMenu :LinearLayout=view.findViewById(R.id.llMenu)

    }
}