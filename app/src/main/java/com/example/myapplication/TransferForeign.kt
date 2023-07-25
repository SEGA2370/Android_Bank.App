package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import java.util.Locale

class TransferForeign : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ForeignData>()
    private lateinit var adapter: ForeignAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_foreign)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = ForeignAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        val transferback = findViewById<ImageButton>(R.id.currency_back_button)
        transferback.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<ForeignData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList(){
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Kazakhstan", R.drawable.kazakhstan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Uzbekistan", R.drawable.uszbekistan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Russia", R.drawable.russia))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Kazakhstan", R.drawable.kazakhstan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Uzbekistan", R.drawable.uszbekistan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Russia", R.drawable.russia))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Kazakhstan", R.drawable.kazakhstan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Uzbekistan", R.drawable.uszbekistan))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Russia", R.drawable.russia))
        mList.add(ForeignData("Palestine", R.drawable.palestine))
        mList.add(ForeignData("Turkey", R.drawable.turkey))
        mList.add(ForeignData("Palestine", R.drawable.palestine))

    }

}