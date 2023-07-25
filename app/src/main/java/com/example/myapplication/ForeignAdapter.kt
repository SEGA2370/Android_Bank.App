package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForeignAdapter (var mList: List<ForeignData>) :
    RecyclerView.Adapter<ForeignAdapter.ForeignViewHolder>() {

    inner class ForeignViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilteredList(mList: List<ForeignData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForeignViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.foreign_each_item , parent , false)
        return ForeignViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForeignViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}