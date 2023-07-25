package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransferAlifCard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private  var mList = ArrayList<TransferAlifCardData>()
    private lateinit var adapter: TransferAlifCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_alif_card)

        recyclerView = findViewById(R.id.recyclerViewCard_alifmobi)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = TransferAlifCardAdapter(mList)
        recyclerView.adapter = adapter

        val transferback = findViewById<ImageButton>(R.id.transfer_back_button)
        transferback.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun addDataToList() {
        mList.add(TransferAlifCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444****VSA**1673"))
        mList.add(TransferAlifCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "4444*****1673"))
        mList.add(TransferAlifCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(TransferAlifCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "4444***VSA**9103"))
        mList.add(TransferAlifCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444****VSA**1673"))
        mList.add(TransferAlifCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "4444*****1673"))
        mList.add(TransferAlifCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(TransferAlifCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "4444***VSA**9103"))
        mList.add(TransferAlifCardData("Фарзон М." , R.drawable.transfer_alifmobi_one , "4444***VSA**9103"))
        mList.add(TransferAlifCardData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "5058***ALF**9872"))
        mList.add(TransferAlifCardData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "5058***ALF**9872"))
        mList.add(TransferAlifCardData("Махина Д." , R.drawable.transfer_alifmobi_four , "5058***ALF**9872"))

    }
}