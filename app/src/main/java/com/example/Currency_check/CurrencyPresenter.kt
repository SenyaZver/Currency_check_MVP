package com.example.Currency_check

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.Currency_check.Common.Contact
import com.example.Currency_check.Common.RecyclerViewAdapter


class CurrencyPresenter(override var model: Contact.Model, var recyclerView: RecyclerView) : Contact.Presenter {

    private var view: Contact.View? = null

    init {
        recyclerView.adapter = RecyclerViewAdapter(model.presentData())
    }



    @SuppressLint("NotifyDataSetChanged")
    fun updatePressed() {
        model.getData()
        recyclerView.adapter?.notifyDataSetChanged()
    }


    override fun attachView(view: Contact.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

}