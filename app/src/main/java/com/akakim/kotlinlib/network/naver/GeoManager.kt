package com.akakim.kotlinlib.network.naver

import android.util.Log
import com.akakim.kotlinlib.data.NaverAPIErrorItem
import com.akakim.kotlinlib.data.NaverGeoCoding
import com.akakim.kotlinlib.data.NaverSearchAPI
import com.akakim.kotlinlib.network.APICallback
import com.akakim.kotlinlib.network.APIManager
import com.akakim.kotlinlib.network.NaverAPIService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class GeoManager : APIManager(){

    fun createNaverGeoHttpClient() : OkHttpClient {
        val builder = OkHttpClient.Builder()

        return builder.addInterceptor {
            val requestBuilder = it.request().newBuilder()

            requestBuilder.addHeader( "X-NCP-APIGW-API-KEY-ID", naverClientID)
            requestBuilder.addHeader( "X-NCP-APIGW-API-KEY", naverClientSecrete)
            requestBuilder.addHeader( "Accept", "application/json")

            it.proceed( requestBuilder.build())
        }.build()
    }

    fun geoCall( naverAPICallback : APICallback){

        val builder = GsonBuilder()

        // 네트워크 설정.
        val geoRetrofit : Retrofit = Retrofit.Builder()
            .baseUrl(host)
            .client( createNaverGeoHttpClient() )
            .addConverterFactory(GsonConverterFactory.create( builder.create() ))
            .build()


        Runnable {
            val geoService = geoRetrofit.create(GeoAPIService::class.java)
            geoService.getTestData().enqueue(object: Callback<NaverGeoCoding>{
                override fun onFailure(call: Call<NaverGeoCoding>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<NaverGeoCoding>,
                    response: Response<NaverGeoCoding>
                ) {
                    Log.d( "onResponse", response.code().toString())

                    response.errorBody()?.apply {
                        val errorItem = Gson().fromJson( charStream(),NaverAPIErrorItem::class.java)

                        Log.d( "onErrorBody", errorItem.toString())

                    }

                    response.body()?.apply {
                        Log.d( "onSuccess", this.address)

                    }
                    naverAPICallback.apiResponseCallback( call , response )
                }
            })
        }
////                        val str = if ( t.message == null ) " null " : t.message
//
//                        Log.e( "apiError" , "error")
//
//                        naverAPICallback.apiError(call , t )
//
//                    }
//
//                    override fun onResponse(call: Call<GeoAPIService>, response: Response<GeoAPIService>) {
//                        Log.d( "onResponse", response.code().toString())
//
//                        response.errorBody()?.apply {
//                            val errorItem = Gson().fromJson( charStream(), NaverAPIErrorItem::class.java)
//
//                            Log.d( "onErrorBody", errorItem.toString())
//
//                        }
//
//                        response.body()?.apply {
//                            Log.d( "onSuccess", this.category)
//
//                        }
//                        naverAPICallback.apiResponseCallback( call , response )
//
//                    }

//                })}.run()

    }
}