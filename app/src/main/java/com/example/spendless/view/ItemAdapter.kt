package com.example.spendless.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spendless.MainActivity
import com.example.spendless.database.items.Items
import com.example.spendless.databinding.ListItemsBinding
import com.example.spendless.model.UserData
import java.text.SimpleDateFormat
import java.util.*



//class ItemAdapter(val c: Context, private val userList: ArrayList<Items>) :
class ItemAdapter(private val onItemClicked: (Items) -> Unit
) :
    ListAdapter<Items, ItemAdapter.ItemViewHolder>(DiffCallback) {


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }
        }
    }

    //    inner class ItemViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
    inner class ItemViewHolder(private var binding: ListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            binding.itemTitle.text = items.title
            binding.itemSubtitle.text = items.amount_spent.toString()
            binding.itemDate.text = SimpleDateFormat(
                "mm-dd-yyyy"
            ).format(items.date).toString()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemAdapter.ItemViewHolder {
        val viewHolder = ItemViewHolder(
            ListItemsBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}