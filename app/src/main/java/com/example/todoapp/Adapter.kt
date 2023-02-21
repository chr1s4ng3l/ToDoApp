package com.example.todoapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.CardviewBinding
import kotlin.collections.List

private const val TAG = "Adapter"
class Adapter(private val item: MutableList<Item>, private val click: (Item) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {


    fun updateItems(newItems: MutableList<Item>) {
        if (item != newItems) {
            item.addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            CardviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    //RecyclerView Size
    override fun getItemCount(): Int = item.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(item[position], click)
}


class ItemViewHolder(private val binding: CardviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item, click: (Item) -> Unit) {
        binding.txtCard.text = item.item
        itemView.setOnClickListener {
            click(item)
        }

    }

}