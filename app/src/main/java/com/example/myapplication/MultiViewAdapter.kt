package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutFirstBinding
import com.example.myapplication.databinding.ItemLayoutSecondBinding
import java.lang.IllegalArgumentException

class MultiViewAdapter(private val list: ArrayList<DataModel>, private val listener: MyClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FIRST_VIEW -> FirstViewHolder(
                ItemLayoutFirstBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            SECOND_VIEW -> SecondViewHolder(
                ItemLayoutSecondBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].theViewType) {
            FIRST_VIEW -> {
                val firstViewHolder = holder as FirstViewHolder
                firstViewHolder.bind(list[position])
                firstViewHolder.itemView.setOnClickListener {
                    listener.onClick(position)
                }
            }
            SECOND_VIEW -> {
                val secondViewHolder = holder as SecondViewHolder
                secondViewHolder.bind(list[position])
                secondViewHolder.itemView.setOnClickListener {
                    listener.onClick(position)
                }
            }
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].theViewType
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }

}