package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageTransferCard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<MainPageTransferCardData>()
    private lateinit var adapter: MainPageTransferCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_transfer_card)

        recyclerView = findViewById(R.id.recyclerViewCard)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = MainPageTransferCardAdapter(mList)
        recyclerView.adapter = adapter

        val transferback = findViewById<ImageButton>(R.id.transfer_back_button)
        transferback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addDataToList() {
        mList.add(MainPageTransferCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444****VSA**1673"))
        mList.add(MainPageTransferCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "4444*****1673"))
        mList.add(MainPageTransferCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(MainPageTransferCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "4444***VSA**9103"))
        mList.add(MainPageTransferCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444****VSA**1673"))
        mList.add(MainPageTransferCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "4444*****1673"))
        mList.add(MainPageTransferCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(MainPageTransferCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "4444***VSA**9103"))
        mList.add(MainPageTransferCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444***VSA**9103"))
        mList.add(MainPageTransferCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "5058***ALF**9872"))
        mList.add(MainPageTransferCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(MainPageTransferCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "5058***ALF**9872"))

    }

}