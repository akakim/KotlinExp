package com.akakim.kotlinlib.network

import com.akakim.kotlinlib.data.NaverSearchAPI
import com.akakim.kotlinlib.util.DLog
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
class APIManager() {
    val searchAPI = "https://openapi.naver.com/"
    val api = "v1/search/local.json"

    val action = { msg : String -> DLog.d(msg) }

    val naverClientID = "qD8w5T7FSGCfZzuwZfzz"
    val naverClientSecrete ="susq0pojQF"


    companion object{

//        private lateinit var instance : APIManager

        @Volatile private var instance: APIManager? = null

        @JvmStatic fun getInstance(): APIManager =
            instance ?: synchronized(this) {
                instance ?: APIManager().also {
                    instance = it
                }
            }

//        fun getInstance(): APIManager {
//
//            if( instance == null)
//                instance = APIManager()
//
//            return instance
//        }
    }

    fun createNaverHttpClient() : OkHttpClient{
        val builder = OkHttpClient.Builder()

        return builder.addInterceptor {
            val requestBuilder = it.request().newBuilder()

            requestBuilder.addHeader( "X-Naver-Client-Id", naverClientID)
            requestBuilder.addHeader( "X-Naver-Client-Secret", naverClientSecrete)

            it.proceed( requestBuilder.build())
        }.build()
    }

    fun naverAPISearch( naverAPICallback : APICallback){
        // data 가 복잡하기 때문에 커스터마이징이 들어감.
        // data 가 복잡하기 때문에 커스터마이징이 들어감.
        val builder = GsonBuilder()

        // 네트워크 설정.
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(searchAPI)
            .client( createNaverHttpClient() )
            .addConverterFactory(GsonConverterFactory.create( builder.create() ))
            .build()


        Runnable {
            val naverSearchAPI = retrofit.create(NaverAPIService::class.java)
            naverSearchAPI.getTestData().enqueue(
                object: Callback<NaverSearchAPI>{
                    override fun onFailure(call: Call<NaverSearchAPI>, t: Throwable) {

//                        val str = if ( t.message == null ) " null " : t.message

                        Log.e( "apiError" , "error")

                        naverAPICallback.apiError(call , t )

                    }

                    override fun onResponse(call: Call<NaverSearchAPI>, response: Response<NaverSearchAPI>) {
                        Log.d( "onResponse", response.code().toString())

                        response.errorBody()?.apply {
                            Log.d( "onErrorBody", this.contentLength().toString())

                        }

                        response.body()?.apply {
                            Log.d( "onSuccess", this.category)

                        }
                        naverAPICallback.apiResponseCallback( call , response )

                    }


                })
        }
    }

}