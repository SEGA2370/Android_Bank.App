package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoreAdapter(private val moreList:ArrayList<ItemMore> , val listener:MyClickListener)
    : RecyclerView.Adapter<MoreAdapter.MoreItemViewHolder>() {

    inner class MoreItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_item , parent , false)
        return MoreItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  moreList.size
    }

    override fun onBindViewHolder(holder: MoreItemViewHolder, position: Int) {
        val more = moreList[position]
        holder.imageView.setImageResource(more.image)
        holder.textView.text = more.name
    }

    interface  MyClickListener{
        fun onClick(position: Int)
    }

}