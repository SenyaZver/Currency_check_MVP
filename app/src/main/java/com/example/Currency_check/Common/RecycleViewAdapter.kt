package com.example.Currency_check.Common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Currency_check.R

class RecyclerViewAdapter(private val currencyList: ArrayList<Currency>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.name)
        val valueView: TextView = view.findViewById(R.id.value)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameView.text = currencyList[position].name
        holder.valueView.text = currencyList[position].value.toString()
    }

    override fun getItemCount() = currencyList.size

}