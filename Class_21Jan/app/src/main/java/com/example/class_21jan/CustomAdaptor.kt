package com.example.class_21jan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdaptor(private val itemList: List<Pet>) :RecyclerView.Adapter<CustomAdaptor.CustomViewHolder>() {

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val age: TextView = itemView.findViewById(R.id.age)
        val phhp: TextView = itemView.findViewById(R.id.phhp)
        val mehp: TextView = itemView.findViewById(R.id.mehp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pet, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.name.text = currentItem.name
        holder.age.text = currentItem.age.toString()
        holder.phhp.text = currentItem.phhp.toString()
        holder.mehp.text = currentItem.mehp.toString()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}