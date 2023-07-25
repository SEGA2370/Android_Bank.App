package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransferAlifmobiAdapter (var mList: List<TransferAlifmobiData>) :
        RecyclerView.Adapter<TransferAlifmobiAdapter.AlifmobiViewHolder>(){

            inner class AlifmobiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
             val logo : ImageView = itemView.findViewById(R.id.imageViewTransfer)
             val title : TextView = itemView.findViewById(R.id.textViewTransfer)
             val number : TextView = itemView.findViewById(R.id.numberViewTransfer)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlifmobiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transfer_alifmobi_item , parent , false)
        return  AlifmobiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: AlifmobiViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.title.text = mList[position].title
        holder.number.text = mList[position].number
    }

}