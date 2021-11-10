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
        arrayList.add(Model("Ideal"))
        arrayList.add(Model("Maestro"))
        arrayList.add(Model("Visa"))

        val myAdapter = MyRecyclerViewAdapter(arrayList)


        findViewById<RecyclerView>(R.id.recyclerview).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerview).adapter = myAdapter
    }
}