package com.example.Currency_check

import android.app.Application

class MVPapp: Application() {

    lateinit var presenter: CurrencyPresenter

    override fun onCreate() {
        super.onCreate()

        presenter = CurrencyPresenter(CurrencyModel())


    }


}