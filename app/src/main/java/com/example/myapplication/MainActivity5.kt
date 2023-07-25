package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity5 : AppCompatActivity(),MoreAdapter.MyClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moreList : ArrayList<ItemMore>
    private lateinit var moreAdapter : MoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        moreList = ArrayList()

        moreList.add(ItemMore(R.drawable.alif_fifth_page_details , "Personal Details"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_lock , "Security"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_notify , "Notification"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_language , "Language"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_theme , "Theme"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_map , "Offices and ATM's"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_questions , "Most asked questions"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_documents , "Documents"))
        moreList.add(ItemMore(R.drawable.alif_fifth_page_aboutus_ , "About App"))



        moreAdapter = MoreAdapter(moreList, this@MainActivity5)
        recyclerView.adapter = moreAdapter


        val transfer = findViewById<ImageButton>(R.id.toolbar_home)
        transfer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val transfer2 = findViewById<ImageButton>(R.id.toolbar_history)
        transfer2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        val transfer1 = findViewById<ImageButton>(R.id.toolbar_transfer)
        transfer1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        val transfer4 = findViewById<ImageButton>(R.id.toolbar_loan)
        transfer4.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
        val transfer5 = findViewById<ImageButton>(R.id.toolbar_more)
        transfer5.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        val transferQr = findViewById<ImageButton>(R.id.more_Qr_code)
        transferQr.setOnClickListener {
            val intent = Intent(this, MoreQrCode::class.java)
            startActivity(intent)
        }
        val transferLimits = findViewById<ImageButton>(R.id.more_limits)
        transferLimits.setOnClickListener {
            val intent = Intent(this, MoreLimits::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(position: Int) {
      when(position){
          0-> startActivity(Intent(this,MorePersonalDetails::class.java))
          1-> startActivity(Intent(this,MoreSecurity::class.java))
          2-> startActivity(Intent(this,MoreNotify::class.java))
          4-> startActivity(Intent(this,MoreTheme::class.java))
          5-> startActivity(Intent(this,MoreMap::class.java))
          6-> startActivity(Intent(this,MoreQuestions::class.java))
          7-> startActivity(Intent(this,MoreDocuments::class.java))
      }
    }
}