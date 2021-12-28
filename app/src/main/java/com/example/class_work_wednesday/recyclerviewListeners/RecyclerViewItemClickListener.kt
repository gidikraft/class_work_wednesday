package com.example.class_work_wednesday.recyclerviewListeners

import com.example.class_work_wednesday.model.Model

interface RecyclerViewItemClickListener {
    fun onDeleteButtonClicked(model: Model)

    fun onAddButtonClicked(model: Model)
}