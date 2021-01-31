package com.akakim.kotlinlib.data

import com.google.gson.annotations.SerializedName

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
data class NaverSearchAPI(
    @SerializedName("rss")
    val rss : String,
    @SerializedName("channel")
    val channel: String,
    @SerializedName("total")
    val total: Int,
    @SerializedName("start")
    val start: Int,
    @SerializedName("display")
    val display: Int,
    @SerializedName("category")
    val category: String,
    @SerializedName("items")
    val naverSearchListSearch: MutableList<NaverAPISearchItem>
) {
}