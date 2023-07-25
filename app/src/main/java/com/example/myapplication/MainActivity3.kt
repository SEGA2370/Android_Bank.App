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

class MainActivity3 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<HistoryData>()
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recyclerView = findViewById(R.id.recyclerViewHistory)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = HistoryAdapter(mList)
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

        val transfer = findViewById<ImageButton>(R.id.toolbar_home)
        transfer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val transfer1 = findViewById<ImageButton>(R.id.toolbar_transfer)
        transfer1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val transfer2 = findViewById<ImageButton>(R.id.toolbar_history)
        transfer2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val transfer3 = findViewById<ImageButton>(R.id.toolbar_loan)
        transfer3.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        val transfer4 = findViewById<ImageButton>(R.id.toolbar_more)
        transfer4.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<HistoryData>()
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

    private fun addDataToList() {
        mList.add(
            HistoryData(
                "Перевод от Alif Platinum",
                R.drawable.third_page_one,
                "+90c.",
                "Перевод от Alif Platinum  +90c"
            )
        )
        mList.add(
            HistoryData(
                "Покупка в FACEBK",
                R.drawable.third_page_two,
                "-13,68c.",
                "Покупка в FACEBK -13,68c"
            )
        )
        mList.add(
            HistoryData(
                "Погашение рассрочки",
                R.drawable.third_page_three,
                "-6.20c.",
                "Погашение рассрочки -6.20c."
            )
        )
        mList.add(
            HistoryData(
                "Перевод на карту Комрончон А.",
                R.drawable.third_page_four,
                "-200с.",
                "Перевод на карту Комрончон А. -200с."
            )
        )
        mList.add(
            HistoryData(
                "Перевод от Зебо А.",
                R.drawable.third_page_one,
                "+60c.",
                "Перевод от Зебо А. +60c."
            )
        )
        mList.add(
            HistoryData(
                "Пополнение через alif mobi",
                R.drawable.third_page_four,
                "+100c.",
                "Пополнение через alif mobi  +100c"
            )
        )
        mList.add(
            HistoryData(
                "Перевод на карту Сиёвуш Д.",
                R.drawable.third_page_four,
                "-100с.",
                "Перевод на карту Сиёвуш Д.  -100с."
            )
        )
        mList.add(
            HistoryData(
                "Погашение рассрочки",
                R.drawable.third_page_three,
                "-3.10с.",
                "Погашение рассрочки -3.10с"
            )
        )
        mList.add(
            HistoryData(
                "Перевод от Alif Platinum",
                R.drawable.third_page_one,
                "+90c.",
                "Перевод от Alif Platinum  +90c"
            )
        )
        mList.add(
            HistoryData(
                "Покупка в FACEBK",
                R.drawable.third_page_two,
                "-13,68c.",
                "Покупка в FACEBK -13,68c"
            )
        )
        mList.add(
            HistoryData(
                "Погашение рассрочки",
                R.drawable.third_page_three,
                "-6.20c.",
                "Погашение рассрочки -6.20c."
            )
        )
        mList.add(
            HistoryData(
                "Перевод на карту Комрончон А.",
                R.drawable.third_page_four,
                "-200с.",
                "Перевод на карту Комрончон А. -200с."
            )
        )
        mList.add(
            HistoryData(
                "Перевод от Зебо А.",
                R.drawable.third_page_one,
                "+60c.",
                "Перевод от Зебо А. +60c."
            )
        )
        mList.add(
            HistoryData(
                "Пополнение через alif mobi",
                R.drawable.third_page_four,
                "+100c.",
                "Пополнение через alif mobi  +100c"
            )
        )
        mList.add(
            HistoryData(
                "Перевод на карту Сиёвуш Д.",
                R.drawable.third_page_four,
                "-100с.",
                "Перевод на карту Сиёвуш Д.  -100с."
            )
        )
        mList.add(
            HistoryData(
                "Погашение рассрочки",
                R.drawable.third_page_three,
                "-3.10с.",
                "Погашение рассрочки -3.10с"
            )
        )
    }
}