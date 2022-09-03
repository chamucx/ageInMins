package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null
    private var tvSelectedDateInMinutes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)

        btnDatePicker.setOnClickListener {

            clickDatePicker()

        }
    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val presentDate =
            DatePickerDialog(
                this,
                { view, selectedYear, selectedMonth, dayOfMonth ->
                    Toast.makeText(
                        this,
                        "Year was $selectedYear, month ${selectedMonth + 1}, day of month $dayOfMonth",
                        Toast.LENGTH_LONG
                    ).show()

                    val selectedDate = "$dayOfMonth/${selectedMonth + 1}/${selectedYear}"
                    tvSelectedDate?.text = selectedDate

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val theDate = sdf.parse(selectedDate)
                    theDate?.let {
                        val selectedDateInMins = theDate.time / 60000

                        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                        val currentDateInMinutes = currentDate.time / 60000

                        val differenceInMins = currentDateInMinutes - selectedDateInMins
                        tvSelectedDateInMinutes?.text = differenceInMins.toString()
                    }
                },
                year, month, day
            )

        presentDate.datePicker.maxDate = System.currentTimeMillis() - 86400000
        presentDate.show()

    }
}