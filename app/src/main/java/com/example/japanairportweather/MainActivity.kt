package com.example.japanairportweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectAirportButton = findViewById<Button>(R.id.selectAirportButton)
        selectAirportButton.setOnClickListener {
            val intent = Intent(this, WeatherInfoActivity::class.java)
            intent.putExtra("ICAO", "RJAA")
            startActivity(intent)
        }
    }
}