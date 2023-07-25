package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import omari.hamza.storyview.StoryView
import omari.hamza.storyview.callback.StoryClickListeners
import omari.hamza.storyview.model.MyStory
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity(),MainAdapter.MyClickListener,MainAdapter.MyClickListener2,MainAdapter.MyClickListener3,
                                         MainAdapter.MyClickListener4,MainAdapter.MyClickListener5,MainAdapter.MyClickListener6{

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>
    private lateinit var btn_story : ImageButton
    private lateinit var btn_story_two : ImageButton
    private var listStories : ArrayList<MyStory> = ArrayList()
    private var listStories_two : ArrayList<MyStory> = ArrayList()



    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList, this@MainActivity,this@MainActivity,
                                         this@MainActivity,this@MainActivity,
                                         this@MainActivity,this@MainActivity)
        binding.mainRecyclerView.adapter = adapter

        btn_story = findViewById(R.id.button)

        // Stories button
        btn_story.setOnClickListener {
            val currentstory1 = MyStory(
                "https://exchangerateiq.com/Riq/images/posts/posts_image/1593762776moneyfactor.jpg",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "Fast & Easy Money Transfer"
            )


            val currentstory2 = MyStory(
                "https://images.pexels.com/photos/4386476/pexels-photo-4386476.jpeg?auto=compress&cs=tinysrgb&w=600",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "Im trying to write this app"
            )


            val currentstory3 = MyStory(
                "https://images.pexels.com/photos/3959485/pexels-photo-3959485.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "SeG@-Bank"
            )

            listStories.add(currentstory1)
            listStories.add(currentstory2)
            listStories.add(currentstory3)

            StoryView.Builder(supportFragmentManager)
                .setStoriesList(listStories) // Required
                .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                .setTitleText("SeG@ Bank") // Default is Hidden
                .setSubtitleText("Easy money Movement") // Default is Hidden
                .setTitleLogoUrl("some-link") // Default is Hidden
                .setStoryClickListeners(object : StoryClickListeners {
                    override fun onDescriptionClickListener(position: Int) {

                    }

                    override fun onTitleIconClickListener(position: Int) {

                    }
                }) // Optional Listeners
                .build() // Must be called before calling show method
                .show()

        }

        btn_story_two = findViewById(R.id.button_two)

        // Stories button
        btn_story_two.setOnClickListener {
            val currentstory1 = MyStory(
                "https://images.pexels.com/photos/4712007/pexels-photo-4712007.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "Even Kids need fuel"
            )


            val currentstory2 = MyStory(
                "https://images.pexels.com/photos/9796/car-refill-transportation-transport.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "Fuel up and Pay Later"
            )


            val currentstory3 = MyStory(
                "https://images.pexels.com/photos/3853870/pexels-photo-3853870.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                SimpleDateFormat("MM/dd/yyyy").parse("08/10/2022"),
                "SeG@-Bank Fuel up"
            )

            listStories_two.add(currentstory1)
            listStories_two.add(currentstory2)
            listStories_two.add(currentstory3)

            StoryView.Builder(supportFragmentManager)
                .setStoriesList(listStories_two) // Required
                .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                .setTitleText("SeG@ Bank") // Default is Hidden
                .setSubtitleText("Easy money Movement") // Default is Hidden
                .setTitleLogoUrl("some-link") // Default is Hidden
                .setStoryClickListeners(object : StoryClickListeners {
                    override fun onDescriptionClickListener(position: Int) {

                    }

                    override fun onTitleIconClickListener(position: Int) {

                    }
                }) // Optional Listeners
                .build() // Must be called before calling show method
                .show()

        }



        // Move to Transfer
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

    override fun onBackPressed() {
        this.finishAffinity()
    }

    private fun prepareData(){
        // best seller
        val bestSellerList = ArrayList<RecyclerItem>()
        bestSellerList.add(RecyclerItem(R.drawable.alif_second_mobi , "На" +
                "                                                                        alif mobi"))
        bestSellerList.add(RecyclerItem(R.drawable.alif_second_cardtransfer , "На " +
                "                                                                        карту"))
        bestSellerList.add(RecyclerItem(R.drawable.alif_second_internationaltransfer, "Из России" +
                "                                                                 в Таджикистан"))
        bestSellerList.add(RecyclerItem(R.drawable.alif_second_russiatransfer, "Переводы " +
                "                                                                 за рубеж"))
        bestSellerList.add(RecyclerItem(R.drawable.alif_second_unistream, "Contact, <<Юнистрим>> " +
                "                                                                и Western Union"))


        //clothing
        val clothingList = ArrayList<RecyclerItem>()
        clothingList.add(RecyclerItem(R.drawable.alif_first_qr , "QR платёж"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_withdraw, "Снятие " +
                "                          наличных"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_services, "Услуги" +
                "                          Алифа"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_phone, "Мобильная " +
                "                          связь"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_electricity, "Свет, вода и отопление"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_wallet, "Кошельки"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_internet , "Услуги интернет"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_transport, "Транспорт"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_taxi, "Такси (для водителей)"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_cardtransfer, "Карты," +
                "                          переводы"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_notification, "Объявления"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_donation, "Фонды,    помощь"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_tv, "ТВ"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_phone, "Зарубежные операторы"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_ngn, "Городская связь,NGN"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_vat, "Оплата государственных"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_shop, "Магазины,    сервисы"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_domen, "Домены,     хостинг"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_study, "Учеба"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_tours, "Туры,билеты"))
        clothingList.add(RecyclerItem(R.drawable.alif_first_services, "Другие"))


        //Cards
        val cardsList = ArrayList<RecyclerItem>()
        cardsList.add(RecyclerItem(R.drawable.alif_third_visaicon, "0,02TJS"))
        cardsList.add(RecyclerItem(R.drawable.alif_third_iconalif, "0 TJS"))
        cardsList.add(RecyclerItem(R.drawable.alif_third_add, "Add Card"))

        //Offers
        val offerList = ArrayList<RecyclerItem>()
        offerList.add(RecyclerItem(R.drawable.alif_fourth_aladdin, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_nutrition, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_defacto, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_fkc, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_efendi, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_simple, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_somonoil, ""))
        offerList.add(RecyclerItem(R.drawable.alif_fourth_tynor, ""))


        //Header Text
        val headerList = ArrayList<RecyclerItem>()
        headerList.add(RecyclerItem(R.drawable.alif_text_back,"Попоулярное"))
        headerList.add(RecyclerItem(R.drawable.alif_text_back,"Переводы"))
        headerList.add(RecyclerItem(R.drawable.alif_text_back,"Привязвнные карты"))
        headerList.add(RecyclerItem(R.drawable.alif_text_back,"Кэшбеки"))
        headerList.add(RecyclerItem(R.drawable.alif_text_back,"Курс Валюты"))

        //Currency
        val currencyList = ArrayList<RecyclerItem>()
        currencyList.add(RecyclerItem(R.drawable.alif_currency_table," "))

        mList.add(DataItem(DataItemType.HEADER, headerList))
        mList.add(DataItem(DataItemType.CLOTHING, clothingList))
        mList.add(DataItem(DataItemType.HEADER, headerList))
        mList.add(DataItem(DataItemType.BEST_SELLER, bestSellerList))
        mList.add(DataItem(DataItemType.HEADER, headerList))
        mList.add(DataItem(DataItemType.CARDS, cardsList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.alif_order_card)))
        mList.add(DataItem(DataItemType.OFFER, offerList))
        mList.add(DataItem(DataItemType.HEADER, headerList))
        mList.add(DataItem(DataItemType.CURRENCY, currencyList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.alif_shablon)))
    }

    override fun onClick(position: Int) {
        when(position){
            0 -> startActivity(Intent(this, MainPageAlifmobi::class.java))
            1 -> startActivity(Intent(this, MainPageTransferCard::class.java))
            2 -> startActivity(Intent(this, MainPageRussia::class.java))
            3 -> startActivity(Intent(this, MainPageForeignTransfer::class.java))
        }
    }
    override fun onClick2(position: Int) {
        when(position){
            2 -> startActivity(Intent(this,MainAlifServices::class.java))
            3 -> startActivity(Intent(this,MainPageOperator::class.java))
            4 -> startActivity(Intent(this,MainPageElectricity::class.java))
            5 -> startActivity(Intent(this,MainPageWallet::class.java))
            6 -> startActivity(Intent(this,MainPageInternet::class.java))
            7 -> startActivity(Intent(this,MainPageTransport::class.java))
            8 -> startActivity(Intent(this,MainPageTaxi::class.java))
            9 -> startActivity(Intent(this,MainPageCards::class.java))
            10 -> startActivity(Intent(this,MainPageNotification::class.java))
            11 -> startActivity(Intent(this,MainPageFunds::class.java))
            12 -> startActivity(Intent(this,MainPageTv::class.java))
            13 -> startActivity(Intent(this,MainPageForeignOperator::class.java))
            14 -> startActivity(Intent(this,MainPageNgn::class.java))
            15 -> startActivity(Intent(this,MainPageGovermentFee::class.java))
            16 -> startActivity(Intent(this,MainPageShop::class.java))
            17 -> startActivity(Intent(this,MainPageDomen::class.java))
            18 -> startActivity(Intent(this,MainPageSchool::class.java))
            19 -> startActivity(Intent(this,MainPageTour::class.java))
            20 -> startActivity(Intent(this,MainPageMore::class.java))
        }
    }

    override fun onClick3(position: Int) {
        when(position) {
            0 -> startActivity(Intent(this, MainPageVisaCard::class.java))
            1 -> startActivity(Intent(this, MainPageNationalCard::class.java))
            2 -> startActivity(Intent(this, MainPageCreateCard::class.java))
        }
    }
    override fun onClick4(position: Int) {
        when(position) {

        }
    }
    override fun onClick5(position: Int) {
        when(position) {
            0 -> startActivity(Intent(this, MainActivity2::class.java))
            1 -> startActivity(Intent(this, MainActivity2::class.java))
            2 -> startActivity(Intent(this, MainPageHeaderCards::class.java))
            3 -> startActivity(Intent(this, MainPageHeaderCashback::class.java))
            4 -> startActivity(Intent(this, MainPageCurrency::class.java))
        }
    }
    override fun onClick6(position: Int) {
        when(position) {
            0 -> startActivity(Intent(this, MainPageCurrency::class.java))
        }
    }

}