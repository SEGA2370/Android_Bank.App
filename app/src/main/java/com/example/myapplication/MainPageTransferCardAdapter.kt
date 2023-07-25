package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainPageTransferCardAdapter (var mList: List<MainPageTransferCardData>) :
    RecyclerView.Adapter<MainPageTransferCardAdapter.AlifCardViewHolder>(){

    inner class AlifCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.imageViewTransfer)
        val title : TextView = itemView.findViewById(R.id.textViewTransfer)
        val number : TextView = itemView.findViewById(R.id.numberViewTransfer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AlifCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_transfer_alifcard_item , parent , false)
        return  AlifCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainPageTransferCardAdapter.AlifCardViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.title.text = mList[position].title
        holder.number.text = mList[position].number
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}