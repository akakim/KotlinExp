package com.akakim.kotlinlib.data

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-02-07
 */
data class NaverAPIErrorItem(
        @SerializedName("errorMessage")
        val errorMessage:String,
        @SerializedName("errorCode")
        val errorCode :String


) {
    override fun toString(): String {
        return "NaverAPIErrorItem(errorMessage='$errorMessage', errorCode='$errorCode')"
    }
}