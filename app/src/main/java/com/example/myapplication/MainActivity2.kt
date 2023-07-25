package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MultiViewAdapter.Companion.FIRST_VIEW
import com.example.myapplication.MultiViewAdapter.Companion.SECOND_VIEW
import com.example.myapplication.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity(),MultiViewAdapter.MyClickListener {
    private lateinit var binding:ActivityMain2Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()


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

    private fun initView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity2)
        binding.recyclerview.adapter = MultiViewAdapter(getList(),this@MainActivity2)
    }


    private fun getList(): ArrayList<DataModel> {
        return  arrayListOf(
            DataModel(FIRST_VIEW,(R.drawable.second_page_wallet),"На alif mobi", "Без Комиссии или 2%"),
            DataModel(FIRST_VIEW,(R.drawable.second_page_cardtransfer),"На карту", "Перевод на карты Таджикистана и России"),
            DataModel(FIRST_VIEW,(R.drawable.second_page_russia),"Из России в Таджикистан", "Без комиссии на карты <<Корти мили и Visa Алифа>>"),
            DataModel(FIRST_VIEW,(R.drawable.second_page_transfers),"Переводы за рубеж", "Комиссия от 1% -- на карты"),
            DataModel(FIRST_VIEW,(R.drawable.second_page_unistream),"Contact,<<Юнистрим>> и Western Union", "Зачисление перевода на карты <<Корти милли>> и Visa Алифа"),

            DataModel(SECOND_VIEW,(R.drawable.second_page_first),"Услуги Алифа", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_second),"Мобильная Связь", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_third),"Свет,вода и отопление", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_fourth),"Кошельки", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_fifth),"Услуги Интернет", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_sixth),"Транспорт", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_seventh),"Такси(для водителей)", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_eighth),"Карты, переводы", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_nine),"Объявление", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_ten),"Фонды,помощь", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_eleventh),"ТВ", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_twelve),"Зарубежные операторы", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_thirteen),"Городская связь,NGN", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_fourteen),"Оплата государственных услуг", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_fifteen),"Магазины, сервисы", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_sixteen),"Социальные сети", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_seventeen),"Домен,хостинг", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_eighteen),"Учеба", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_nineteen),"Туры,билеты", ""),
            DataModel(SECOND_VIEW,(R.drawable.second_page_twenty),"Другие", ""),
            )
    }

    override fun onClick(position: Int) {
        when(position){
            0-> startActivity(Intent(this,TransferAlifCard::class.java))
            1-> startActivity(Intent(this,Transfer_Alifmobi::class.java))
            2-> startActivity(Intent(this,RussiaTajTransfer::class.java))
            3-> startActivity(Intent(this,TransferForeign::class.java))
            5-> startActivity(Intent(this,TransferServices::class.java))
            6-> startActivity(Intent(this,TransferOperator::class.java))
            7-> startActivity(Intent(this,TransferElectricity::class.java))
            8-> startActivity(Intent(this,TransferWallet::class.java))
            9-> startActivity(Intent(this,TransferInternet::class.java))
            10-> startActivity(Intent(this,TransferTransport::class.java))
            11-> startActivity(Intent(this,TransferTaxi::class.java))
            12-> startActivity(Intent(this,TransferCards::class.java))
            13-> startActivity(Intent(this,TransferNotification::class.java))
            14-> startActivity(Intent(this,TransferFunds::class.java))
            15-> startActivity(Intent(this,TransferTv::class.java))
            16-> startActivity(Intent(this,TransferForeignOperator::class.java))
            17-> startActivity(Intent(this,TransferNgn::class.java))
            18-> startActivity(Intent(this,TransferGovermentFee::class.java))
            19-> startActivity(Intent(this,TransferShop::class.java))
            20-> startActivity(Intent(this,TransferSocial::class.java))
            21-> startActivity(Intent(this,TransferDomen::class.java))
            22-> startActivity(Intent(this,TransferSchool::class.java))
            23-> startActivity(Intent(this,TransferTour::class.java))
            24-> startActivity(Intent(this,TransferMore::class.java))



        }
    }

}
