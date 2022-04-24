package com.example.Currency_check.Common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface Contact {

    interface Presenter {
        var model: Model

        fun attachView(view: View, recyclerView: RecyclerView)

        fun detachView()

    }

    interface View {
        fun displayData()
        fun updateData()

    }

    interface Model {
        fun presentData(): ArrayList<Currency>
        fun getData()
    }

}