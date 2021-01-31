package com.akakim.kotlinlib.network

import com.akakim.kotlinlib.data.NaverSearchAPI
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */

interface APICallback{
    fun apiResponseCallback(call: Call<NaverSearchAPI>, response: Response<NaverSearchAPI>)
    fun apiError(call: Call<NaverSearchAPI>, t: Throwable )

}