package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutFirstBinding
import com.example.myapplication.databinding.ItemLayoutSecondBinding

class SecondViewHolder(private val binding: ItemLayoutSecondBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel){
        binding.image.setImageResource(dataModel.image)
        binding.title.text = dataModel.title
        binding.description.text = dataModel.description
    }
}