package com.example.japanairportweather.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
data class Airport @JvmOverloads constructor(

    @field:Element(name = "icaoCode")
    @param:Element(name = "icaoCode")
    var icaoCode: String = "",

    @field:Element(name = "airportName")
    @param:Element(name = "airportName")
    var airportName: String = "",

    @field:Element(name = "metarMsg")
    @param:Element(name = "metarMsg")
    var metarMsg: String = ""
) : Serializable

@Root(name = "items", strict = false)
data class Items @JvmOverloads constructor(
    @field:ElementList(entry = "item", inline = true, required = false)
    @param:ElementList(entry = "item", inline = true, required = false)
    val airports: List<Airport>? = null
)
@Root(name = "response", strict = false)
data class ApiResponse @JvmOverloads constructor(

    @field:Element(name = "header", required = false)
    @param:Element(name = "header", required = false)
    val header: Header? = null,

    @field:Element(name = "body", required = false)
    @param:Element(name = "body", required = false)
    val body: Body? = null
)

@Root(name = "header", strict = false)
data class Header @JvmOverloads constructor(

    @field:Element(name = "resultCode")
    @param:Element(name = "resultCode")
    val resultCode: String = "",

    @field:Element(name = "resultMsg")
    @param:Element(name = "resultMsg")
    val resultMsg: String = ""
)

@Root(name = "body", strict = false)
data class Body @JvmOverloads constructor(

    @field:Element(name = "dataType")
    @param:Element(name = "dataType")
    val dataType: String = "",

    @field:Element(name = "items", required = false)
    @param:Element(name = "items", required = false)
    val items: Items? = null,

    @field:Element(name = "numOfRows")
    @param:Element(name = "numOfRows")
    val numOfRows: Int = 0,

    @field:Element(name = "pageNo")
    @param:Element(name = "pageNo")
    val pageNo: Int = 0,

    @field:Element(name = "totalCount")
    @param:Element(name = "totalCount")
    val totalCount: Int = 0
)