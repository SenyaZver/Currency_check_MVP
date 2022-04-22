package com.example.Currency_check

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Currency_check.Common.Contact
import com.example.Currency_check.Common.Currency
import com.example.Currency_check.Common.RecyclerViewAdapter

class MainActivity : AppCompatActivity(), Contact.View {

    private lateinit var updateButton: Button

    private lateinit var presenter: CurrencyPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    fun init() {
        updateButton = findViewById(R.id.updateButton)
        updateButton.setOnClickListener{
            updateData()
        }


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        presenter = CurrencyPresenter(CurrencyModel(), recyclerView)
        presenter.attachView(this)
    }


    override fun displayData() {
        Toast.makeText(this, "Data displayed!", Toast.LENGTH_SHORT).show()
    }

    override fun updateData() {
        presenter.updatePressed()
        Toast.makeText(this, "Data updated!", Toast.LENGTH_SHORT).show()
    }
}