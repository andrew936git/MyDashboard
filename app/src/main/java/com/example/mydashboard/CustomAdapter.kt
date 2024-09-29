package com.example.mydashboard

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context):
    RecyclerView.Adapter<CustomAdapter.ContactViewHolder>(){

    private val users = ArrayList<User>()


    inner class ContactViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.idTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<User>){
        users.clear()
        users.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val viewHolder = ContactViewHolder(
            LayoutInflater
            .from(context)
            .inflate(R.layout.list_item, parent, false))
        return viewHolder
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val user = users[position]
        holder.idTextView.text = user.id.toString()
        holder.nameTextView.text = user.name
    }


}