package com.example.Currency_check

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.Currency_check.Common.Contact
import com.example.Currency_check.Common.RecyclerViewAdapter


class CurrencyPresenter(override var model: Contact.Model) : Contact.Presenter {

    private var view: Contact.View? = null

    lateinit var recyclerView: RecyclerView



    @SuppressLint("NotifyDataSetChanged")
    fun updatePressed() {
        model.getData()
        recyclerView.adapter?.notifyDataSetChanged()
    }


    override fun attachView(view: Contact.View, recyclerView: RecyclerView) {
        this.view = view
        this.recyclerView = recyclerView
        recyclerView.adapter = RecyclerViewAdapter(model.presentData())
    }

    override fun detachView() {
        this.view = null
    }

}