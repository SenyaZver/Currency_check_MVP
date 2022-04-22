package com.example.Currency_check

import android.util.Log
import com.example.Currency_check.Common.Contact
import com.example.Currency_check.Common.Currency
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CurrencyModel() : Contact.Model {

    private var currencyList: ArrayList<Currency> = ArrayList()
    private val client: OkHttpClient = OkHttpClient()

    init {
        getData()
    }

    override fun presentData(): ArrayList<Currency> {
        return currencyList
    }

    override fun getData() {
        updateList()
    }


    private fun updateList() {
        val array: ArrayList<Currency> = ArrayList()

        val CB_url = "https://www.cbr-xml-daily.ru/daily_json.js"
        val request = Request.Builder()
            .url(CB_url)
            .build()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("request", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {

                val jsonString = response.body?.string()
                val Valute: JSONObject? = jsonString?.let { JSONObject(it) }?.getJSONObject("Valute")


                val iterator = Valute?.keys()

                while (iterator!!.hasNext()) {
                    val currency: JSONObject? = Valute.getJSONObject(iterator.next())

                    if (currency == null) {
                        Log.d("tag", "null")
                        return
                    }

                    val name:String = currency.getString("Name")
                    val value:Double = currency.getDouble("Value")

                    array.add(Currency(name, value))
                }
            }
        })
        currencyList = array
    }



}