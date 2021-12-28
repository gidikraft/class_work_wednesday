package com.example.class_work_wednesday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.class_work_wednesday.adapter.MyRecyclerViewAdapter
import com.example.class_work_wednesday.databinding.ActivityMainBinding
import com.example.class_work_wednesday.model.Model
import com.example.class_work_wednesday.recyclerviewListeners.RecyclerViewItemClickListener
import com.example.class_work_wednesday.recyclerviewListeners.SwipeGesture
import com.google.android.material.appbar.AppBarLayout
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class MainActivity : AppCompatActivity(), RecyclerViewItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private var itemCount = 1
    private lateinit var searchArray : ArrayList<Model>
    private lateinit var cardList : ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardList = arrayListOf()

        cardList.add(Model("Discover"))
        cardList.add(Model("iDEAL"))
        cardList.add(Model("Maestro"))
        cardList.add(Model("Visa"))
        cardList.add(Model("Diner's club"))
        cardList.add(Model("Mastercard"))
        cardList.add(Model("American Express"))
        cardList.add(Model("Visa"))
        cardList.add(Model("payFast"))
        cardList.add(Model("Boncontact"))

        searchArray = arrayListOf()
        searchArray.addAll(cardList)

        val myAdapter = MyRecyclerViewAdapter(searchArray, this@MainActivity)

        binding.cardsRecyclerview.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = myAdapter
        }

        val swipeToDelete = object : SwipeGesture(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                cardList.removeAt(position)
                binding.cardsRecyclerview.adapter?.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDelete)

        itemTouchHelper.attachToRecyclerView(binding.cardsRecyclerview)

        binding.toolbar.title = "Cart"
        binding.labelTv.text = "You have ${cardList.size} items in your cart"

//        appBarOffsetChangedListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchArray.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    cardList.forEach{
                        if (it.title.lowercase(Locale.getDefault()).contains(searchText)){
                            searchArray.add(it)
                        }
                    }
                    binding.cardsRecyclerview.adapter!!.notifyDataSetChanged()
                } else {
                    searchArray.clear()
                    searchArray.addAll(cardList)
                    binding.cardsRecyclerview.adapter!!.notifyDataSetChanged()

                }

                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun appBarOffsetChangedListener(){
        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{
                appBarLayout, verticalOffset ->

            val offset = abs(verticalOffset)
            val scrollRange = appBarLayout.totalScrollRange

            val alpha = offset.toFloat() / scrollRange.toFloat()
            binding.labelTv.alpha = alpha
        })
    }

    override fun onDeleteButtonClicked(model: Model) {
        if (itemCount >= 1){
            findViewById<TextView>(R.id.item_count).text = itemCount--.toString()
        }
    }

    override fun onAddButtonClicked(model: Model) {
        findViewById<TextView>(R.id.item_count).text = itemCount++.toString()
    }

}