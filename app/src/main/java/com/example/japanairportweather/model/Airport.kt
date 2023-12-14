package com.example.japanairportweather.model

import java.io.Serializable

data class Airport(
    var icaoCode: String = "",
    var airportName: String = "",
    var imageName: String = "",
    var metarMsg: String = "",
    var reportTime: String? = null,
    var windInfo: String? = null,
    var temperatureInfo: String? = null
) : Serializable

data class Items(
    val airports: List<Airport>? = null
)

data class ApiResponse(
    val header: Header? = null,
    val body: Body? = null
)

data class Header(
    val resultCode: String = "",
    val resultMsg: String = ""
)

data class Body(
    val dataType: String = "",
    val items: Items? = null,
    val numOfRows: Int = 0,
    val pageNo: Int = 0,
    val totalCount: Int = 0
)
