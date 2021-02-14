package com.akakim.kotlinlib.data

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.JsonAdapter

data class NaverGeoCoding (
    @SerializedName("status")
   val status : String,
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
   val mapy: Int){
}