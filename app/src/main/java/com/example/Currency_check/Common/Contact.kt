package com.example.Currency_check.Common

import android.view.View

interface Contact {

    interface Presenter {
        var model: Model

        fun attachView(view: View)

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