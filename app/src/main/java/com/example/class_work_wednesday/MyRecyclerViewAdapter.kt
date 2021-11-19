package com.example.class_work_wednesday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val arrayList: ArrayList<Model>):
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>()  {
        //created inner class (works like a sub class where the item the view will hold is stored, hence, viewHolder)
        inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindItems(model: Model){
                itemView.findViewById<TextView>(R.id.paypal).text = model.title
            }
        }
    //inflates the recyclerview layout to the parent view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cards =  LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return MyViewHolder(cards)
    }
    //binds the into to the recyclerView (which is already inflated into the view)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
    //the size: Int of the item the recyclerView will bind
    override fun getItemCount(): Int {
        return arrayList.size
    }
}