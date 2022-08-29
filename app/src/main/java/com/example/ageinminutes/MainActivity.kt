package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    val tvSelectedDate: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener {

            clickDatePicker()

        }
    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(
            this,
            { view, selectedYear, selectedMonth, dayOfMonth ->
                Toast.makeText(
                    this,
                    "Year was $selectedYear, month ${selectedMonth + 1}, day of month $dayOfMonth",
                    Toast.LENGTH_LONG
                )
                    .show()

            },
            year, month, day
        ).show()


    }
}