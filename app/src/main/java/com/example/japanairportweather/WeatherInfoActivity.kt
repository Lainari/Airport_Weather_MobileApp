package com.example.japanairportweather

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.japanairportweather.model.Airport

class WeatherInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener{
            finish()
        }

        val airport = intent.getSerializableExtra("airport") as Airport

        val imageView: ImageView = findViewById(R.id.airportImageView)
        val imageResId = resources.getIdentifier(airport?.imageName, "drawable", packageName)

        if (imageResId == 0) {
            Log.d("WeatherInfoActivity", "Invalid image name: ${airport?.imageName}")
        } else {
            imageView?.setImageResource(imageResId)
        }

        val icaoCodeTextView: TextView? = findViewById(R.id.icaoCodeTextView)
        icaoCodeTextView?.text = "ICAO 코드: ${airport.icaoCode}"

        val airportNameTextView: TextView? = findViewById(R.id.airportNameTextView)
        airportNameTextView?.text = "공항 이름: ${airport.airportName}"

        val metarMsgTextView: TextView? = findViewById(R.id.metarMsgTextView)
        metarMsgTextView?.text = """
        METAR 메시지: ${airport.metarMsg}
        보고 시간: ${airport.reportTime}
        풍향/풍속 정보: ${airport.windInfo}
        온도/노점온도 정보: ${airport.temperatureInfo}
    """.trimIndent()

    }
}
