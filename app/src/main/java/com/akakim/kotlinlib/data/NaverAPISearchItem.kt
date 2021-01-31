package com.akakim.kotlinlib.data

import com.google.gson.annotations.SerializedName

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
open class NaverAPISearchItem(
    @SerializedName("title")
    val title : String,
    @SerializedName("link")
    val link: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("telephone")
    val telephone: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("roadAddress")
    val roadAddress: String,
    @SerializedName("mapx")
    val mapx: Int,
    @SerializedName("mapy")
    val mapy: Int
){
}