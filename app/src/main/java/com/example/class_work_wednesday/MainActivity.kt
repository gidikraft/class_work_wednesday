package com.example.class_work_wednesday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Discover"))
        arrayList.add(Model("iDEAL"))
        arrayList.add(Model("Maestro"))
        arrayList.add(Model("Visa"))
        arrayList.add(Model("Diner's club"))
        arrayList.add(Model("Mastercard"))
        arrayList.add(Model("American Express"))
        arrayList.add(Model("Visa"))
        arrayList.add(Model("payFast"))
        arrayList.add(Model("Boncontact"))

        val myAdapter = MyRecyclerViewAdapter(arrayList)

        //instantiates the recyclerView to set the context using this layout manager
        findViewById<RecyclerView>(R.id.recyclerview).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerview).adapter = myAdapter
    }
}