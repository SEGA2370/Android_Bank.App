package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

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
}