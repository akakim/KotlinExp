package com.akakim.kotlinlib.network

import com.akakim.kotlinlib.data.NaverSearchAPI
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
interface NaverAPIService {

    @GET(value="v1/search/local.json")
    fun getTestData() : Call<NaverSearchAPI>
}