package com.akakim.kotlinlib.network.naver;

import com.akakim.kotlinlib.data.NaverGeoCoding
import retrofit2.Call
import retrofit2.Response

public interface GeoAPICallback {
    fun apiResponseCallback(call: Call<NaverGeoCoding>, response: Response<NaverGeoCoding>)
    fun apiError(call: Call<NaverGeoCoding>, t: Throwable )
}
