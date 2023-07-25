package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.BestSellerLayoutBinding
import com.example.myapplication.databinding.CardsLayoutBinding
import com.example.myapplication.databinding.ClothingLayoutBinding
import com.example.myapplication.databinding.CurrencyLayoutBinding
import com.example.myapplication.databinding.HeaderLayoutBinding
import com.example.myapplication.databinding.OfferLayoutBinding

class ChildAdapter(private val viewType: Int, private val recyclerItemList: List<RecyclerItem>, private val listener: MainAdapter.MyClickListener,
                   private val listener2: MainAdapter.MyClickListener2,private val listener3: MainAdapter.MyClickListener3,
                   private val listener4: MainAdapter.MyClickListener4,private val listener5: MainAdapter.MyClickListener5,
                   private val listener6: MainAdapter.MyClickListener6) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BestSellerViewHolder(private val binding: BestSellerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBestSellerView(recyclerItem: RecyclerItem) {
            binding.bestSellerImage.setImageResource(recyclerItem.image)
            binding.bestSellerText.text = recyclerItem.offer
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener.onClick(position)
                }
            }
        }
    }


    inner class ClothingViewHolder(private val binding: ClothingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindClothingView(recyclerItem: RecyclerItem) {
            binding.clothingImage.setImageResource(recyclerItem.image)
            binding.clothingOfferTv.text = recyclerItem.offer
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener2.onClick2(position)
                }
            }
        }
    }

    inner class CardsViewHolder(private val binding: CardsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindCardsView(recyclerItem: RecyclerItem) {
            binding.cardsImage.setImageResource(recyclerItem.image)
            binding.cardsText.text = recyclerItem.offer
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener3.onClick3(position)
                }
            }
        }

    }

    inner class OfferViewHolder(private val binding: OfferLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindOfferView(recyclerItem: RecyclerItem) {
            binding.offerImage.setImageResource(recyclerItem.image)
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener4.onClick4(position)
                }
            }
        }

    }

    inner class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindHeaderView(recyclerItem: RecyclerItem) {
            binding.headerImage.setImageResource(recyclerItem.image)
            binding.headerText.text = recyclerItem.offer
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener5.onClick5(position)
                }
            }
        }

    }

    inner class CurrencyViewHolder(private val binding: CurrencyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun currencyHeaderView(recyclerItem: RecyclerItem) {
            binding.currencyUSDImage.setImageResource(recyclerItem.image)
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener6.onClick6(position)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         when(viewType){
             DataItemType.BEST_SELLER ->{
                 val binding = BestSellerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent , false)
                 return  BestSellerViewHolder(binding)
             }
             else ->{
                 return when (viewType){
                     DataItemType.CARDS ->{
                         val binding = CardsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent , false)
                         CardsViewHolder(binding)
                     }

                     else -> {
                         return when (viewType) {
                             DataItemType.CLOTHING->{
                             val binding = ClothingLayoutBinding.inflate(LayoutInflater.from(parent.context), parent , false)
                             ClothingViewHolder(binding)
                         }
                       else ->{
                           return when (viewType) {
                               DataItemType.HEADER->{
                                   val binding = HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent , false)
                                   HeaderViewHolder(binding)
                               }
                               else ->{
                                   return when (viewType) {
                                       DataItemType.CURRENCY-> {
                                           val binding = CurrencyLayoutBinding.inflate(
                                               LayoutInflater.from(parent.context), parent, false
                                           )
                                           CurrencyViewHolder(binding)
                                       }
                                       else ->{
                                           val binding = OfferLayoutBinding.inflate(LayoutInflater.from(parent.context), parent , false)
                                           return OfferViewHolder(binding)
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

    override fun getItemCount(): Int {
        return recyclerItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is BestSellerViewHolder -> {
                holder.bindBestSellerView(recyclerItemList[position])
            }

            is ClothingViewHolder -> {
                holder.bindClothingView(recyclerItemList[position])
            }

            is CardsViewHolder -> {
                holder.bindCardsView(recyclerItemList[position])
            }

            is OfferViewHolder -> {
                holder.bindOfferView(recyclerItemList[position])
            }
            is HeaderViewHolder ->{
                holder.bindHeaderView(recyclerItemList[position])
            }
            is CurrencyViewHolder -> {
                holder.currencyHeaderView(recyclerItemList[position])
            }
        }
    }
}