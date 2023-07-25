package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.BannerItemBinding
import com.example.myapplication.databinding.EachItemBinding

class MainAdapter(private val dataItemList: List<DataItem>, private val listener:MyClickListener,private val listener2:MyClickListener2,
                  private val listener3:MyClickListener3,private val listener4:MyClickListener4,private val listener5:MyClickListener5,
                  private val listener6:MyClickListener6) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class BannerItemViewHolder(private val binding: BannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBannerView(banner: Banner) {
            binding.bannerIv.setImageResource(banner.image)
        }

    }

    inner class RecyclerItemViewHolder(private val binding: EachItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager =
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }

        fun bindClothingRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ChildAdapter(DataItemType.CLOTHING, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter

        }

        fun bindBestSellerRecyclerView(recyclerItemList: List<RecyclerItem>) {

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(binding.childRecyclerView)
            val adapter = ChildAdapter(DataItemType.BEST_SELLER, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindCardsRecyclerView(recyclerItemList: List<RecyclerItem>) {

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(binding.childRecyclerView)
            val adapter = ChildAdapter(DataItemType.CARDS, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindOfferRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ChildAdapter(DataItemType.OFFER, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindHeaderRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ChildAdapter(DataItemType.HEADER, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindCurrencyRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ChildAdapter(DataItemType.CURRENCY, recyclerItemList,listener,listener2,listener3,listener4,listener5,listener6)
            binding.childRecyclerView.adapter = adapter
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (dataItemList[position].viewType) {
            DataItemType.BANNER ->
                R.layout.banner_item
            else ->
                R.layout.each_item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.banner_item -> {
                val binding =
                    BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerItemViewHolder(binding)
            }
            else -> {
                val binding =
                    EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is BannerItemViewHolder -> {
                dataItemList[position].banner?.let { holder.bindBannerView(it) }
            }
            else -> {
                when (dataItemList[position].viewType) {
                    DataItemType.BEST_SELLER -> {
                        dataItemList[position].recyclerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindBestSellerRecyclerView(
                                it
                            )
                        }
                    }
                    else -> {
                        when (dataItemList[position].viewType) {
                            DataItemType.CLOTHING -> {
                                dataItemList[position].recyclerItemList?.let {
                                    (holder as RecyclerItemViewHolder).bindClothingRecyclerView(
                                        it
                                    )
                                }
                            }
                            else -> {
                                when (dataItemList[position].viewType) {
                                    DataItemType.OFFER -> {
                                        dataItemList[position].recyclerItemList?.let {
                                            (holder as RecyclerItemViewHolder).bindOfferRecyclerView(
                                                it
                                            )
                                        }
                                    }

                                    else -> {
                                        when (dataItemList[position].viewType) {
                                            DataItemType.HEADER -> {
                                                dataItemList[position].recyclerItemList?.let {
                                                    (holder as RecyclerItemViewHolder).bindHeaderRecyclerView(
                                                        it
                                                    )
                                                }
                                            }
                                            else -> {
                                                when (dataItemList[position].viewType) {
                                                    DataItemType.CURRENCY -> {
                                                        dataItemList[position].recyclerItemList?.let {
                                                            (holder as RecyclerItemViewHolder).bindCurrencyRecyclerView(
                                                                it
                                                            )
                                                        }
                                                    }
                                                    else ->{
                                                        dataItemList[position].recyclerItemList?.let{
                                                            (holder as RecyclerItemViewHolder).bindCardsRecyclerView(
                                                                it)
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    interface MyClickListener{
        fun onClick(position: Int)
    }

    interface MyClickListener2 {
        fun onClick2(position: Int)
    }
    interface MyClickListener3 {
        fun onClick3(position: Int)
    }
    interface MyClickListener4 {
        fun onClick4(position: Int)
    }
    interface MyClickListener5 {
        fun onClick5(position: Int)
    }
    interface MyClickListener6 {
        fun onClick6(position: Int)
    }
}


