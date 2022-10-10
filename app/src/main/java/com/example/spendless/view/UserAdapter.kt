package com.example.spendless.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spendless.R
import com.example.spendless.model.UserData

class UserAdapter(val c:Context, val userList: ArrayList<UserData>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val v:View): RecyclerView.ViewHolder(v) {
        val item = v.findViewById<TextView>(R.id.item_title)
        val price = v.findViewById<TextView>(R.id.item_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, parent, false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.item.text = newList.item
        holder.price.text = newList.price
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}