package com.example.class_work_wednesday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val arrayList: ArrayList<Model>):
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>()  {

        inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindItems(model: Model){
                itemView.findViewById<TextView>(R.id.paypal).text = model.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cards =  LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return MyViewHolder(cards)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}