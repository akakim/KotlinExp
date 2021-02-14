package com.akakim.kotlinlib.network.naver

import com.akakim.kotlinlib.data.NaverGeoCoding
import com.akakim.kotlinlib.data.NaverSearchAPI
import retrofit2.Call
import retrofit2.http.GET

interface GeoAPIService {

    @GET(value="map-geocode/v2/geocode")
    fun getTestData() : Call<NaverGeoCoding>


}