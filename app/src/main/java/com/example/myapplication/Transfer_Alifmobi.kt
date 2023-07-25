package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Transfer_Alifmobi : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private  var mList = ArrayList<TransferAlifmobiData>()
    private lateinit var adapter: TransferAlifmobiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_alifmobi)

        recyclerView = findViewById(R.id.recyclerViewTransfer_alifmobi)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = TransferAlifmobiAdapter(mList)
        recyclerView.adapter = adapter

        val transferback = findViewById<ImageButton>(R.id.transfer_back_button)
        transferback.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }

    private fun addDataToList() {
         mList.add(TransferAlifmobiData("Фарзон М." , R.drawable.transfer_alifmobi_one , "+992 98 109 8080"))
         mList.add(TransferAlifmobiData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "+992 91 865 5532"))
        mList.add(TransferAlifmobiData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "+992 55 050 5133"))
        mList.add(TransferAlifmobiData("Махина Д." , R.drawable.transfer_alifmobi_four , "+992 88 282 6969"))
        mList.add(TransferAlifmobiData("Фарзон М." , R.drawable.transfer_alifmobi_one , "+992 98 109 8080"))
        mList.add(TransferAlifmobiData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "+992 91 865 5532"))
        mList.add(TransferAlifmobiData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "+992 55 050 5133"))
        mList.add(TransferAlifmobiData("Махина Д." , R.drawable.transfer_alifmobi_four , "+992 88 282 6969"))
        mList.add(TransferAlifmobiData("Фарзон М." , R.drawable.transfer_alifmobi_one , "+992 98 109 8080"))
        mList.add(TransferAlifmobiData("Хикматулло М." , R.drawable.transfer_alifmobi_two , "+992 91 865 5532"))
        mList.add(TransferAlifmobiData("Хуршед Р." , R.drawable.transfer_alifmobi_three , "+992 55 050 5133"))
        mList.add(TransferAlifmobiData("Махина Д." , R.drawable.transfer_alifmobi_four , "+992 88 282 6969"))

    }
}