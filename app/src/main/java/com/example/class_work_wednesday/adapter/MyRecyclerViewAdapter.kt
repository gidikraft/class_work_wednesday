package com.example.class_work_wednesday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.class_work_wednesday.R
import com.example.class_work_wednesday.model.Model
import com.example.class_work_wednesday.recyclerviewListeners.RecyclerViewItemClickListener

class MyRecyclerViewAdapter(private val arrayList: ArrayList<Model>, private val recyclerViewItemListener: RecyclerViewItemClickListener):
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>()  {

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindItems(model: Model){
                itemView.findViewById<TextView>(R.id.card_title).text = model.title
            }

            val deleteButton = itemView.findViewById<ImageButton>(R.id.reduce_item)
            val addButton = itemView.findViewById<ImageButton>(R.id.add_item)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cards =  LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return MyViewHolder(cards)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.deleteButton.setOnClickListener {
            recyclerViewItemListener.onDeleteButtonClicked(arrayList[position])
        }

        holder.addButton.setOnClickListener {
            recyclerViewItemListener.onAddButtonClicked(arrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}