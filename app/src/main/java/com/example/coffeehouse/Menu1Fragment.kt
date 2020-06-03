package com.example.coffeehouse

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeehouse.model.coffee


class Menu1Fragment : Fragment() {
    lateinit var recyclerMenu: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
val CoffeeList= arrayListOf<String>("AFFOGATO",
"CAFFÈ LATTE",
"CAFÈ AU LAIT",
"CAPPUCCINO",
"COLD BREW COFFEE",
"DOUBLE ESPRESSO (DOPPIO)",
"ESPRESSO",
"ICED LATTE",
"IRISH COFFEE",
"FREAKSHAKE")
    lateinit var recyclerAdapter:menuRecyclerAdapter
    val coffeinfo= arrayListOf<coffee>(
        coffee("AFFOGATO","Rs199",R.drawable.affogato_0,"4.0"),

    coffee("CAPPUCCINO","Rs199",R.drawable.cappuccino_0,"4.5"),
        coffee("CAFFÈ LATTE","Rs199",R.drawable.caffeelatte,"4.2"),
        coffee("COLD BREW COFFEE","Rs199",R.drawable.cold,"4.0"),
        coffee("DOUBLE ESPRESSO (DOPPIO)","Rs199",R.drawable.doppio,"3.9"),
        coffee("ESPRESSO","Rs199",R.drawable.espresso,"4.3"),
        coffee("ICED LATTE","Rs199",R.drawable.ice,"4.2"),
        coffee("IRISH COFFEE","Rs199",R.drawable.irish_coffee,"4.0"),
        coffee("FREAKSHAKE","Rs199",R.drawable.freakshake,"4.5"),
        coffee("CAFÈ AU LAIT","Rs199",R.drawable.cafeau,"4.1")







    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_menu1, container, false)
        recyclerMenu=view.findViewById(R.id.recyclerMenu)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= menuRecyclerAdapter(activity as Context,coffeinfo)
        recyclerMenu.adapter=recyclerAdapter
        recyclerMenu.layoutManager=layoutManager
        recyclerMenu.addItemDecoration(
            DividerItemDecoration(recyclerMenu.context,
                (layoutManager as LinearLayoutManager).orientation))
        return view

    }

}
