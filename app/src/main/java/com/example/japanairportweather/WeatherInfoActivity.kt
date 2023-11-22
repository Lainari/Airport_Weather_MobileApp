package com.example.japanairportweather

import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WeatherInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)

        val icao = intent.getStringExtra("ICAO")
        WeatherInfoTask().execute(icao)
    }

    inner class WeatherInfoTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            val apiKey = getString(R.string.api_key)
            val icao = params[0]
            val url = URL("https://apis.data.go.kr/1360000/AftnAmmService/getMetar?serviceKey=$apiKey&pageNo=1&numOfRows=10&dataType=XML&icao=$icao")

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-type", "application/xml")

            val rd: BufferedReader
            rd = if (conn.responseCode >= 200 && conn.responseCode <= 300) {
                BufferedReader(InputStreamReader(conn.inputStream))
            } else {
                BufferedReader(InputStreamReader(conn.errorStream))
            }

            val sb = StringBuilder()
            var line: String?
            while (rd.readLine().also { line = it } != null) {
                sb.append(line)
            }
            rd.close()
            conn.disconnect()

            return sb.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val weatherInfoTextView = findViewById<TextView>(R.id.weatherInfoTextView)
            weatherInfoTextView.text = result // 기상 정보를 화면에 표시합니다.
        }
    }
}