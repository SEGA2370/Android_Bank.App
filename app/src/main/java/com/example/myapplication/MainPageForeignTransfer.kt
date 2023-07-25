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

class MainPageForeignTransfer : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<MainPageForeignTransferData>()
    private lateinit var adapter: MainPageForeignTransferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_foreign_transfer)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = MainPageForeignTransferAdapter(mList)
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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<MainPageForeignTransferData>()
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
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Turkey", R.drawable.turkey))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Kazakhstan", R.drawable.kazakhstan))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Uzbekistan", R.drawable.uszbekistan))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Russia", R.drawable.russia))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Turkey", R.drawable.turkey))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Turkey", R.drawable.turkey))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Kazakhstan", R.drawable.kazakhstan))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Uzbekistan", R.drawable.uszbekistan))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Russia", R.drawable.russia))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))
        mList.add(MainPageForeignTransferData("Turkey", R.drawable.turkey))
        mList.add(MainPageForeignTransferData("Palestine", R.drawable.palestine))

    }
}