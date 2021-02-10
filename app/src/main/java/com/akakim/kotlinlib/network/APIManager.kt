package com.akakim.kotlinlib.network

import android.content.Context
import android.util.Log
import androidx.annotation.RawRes
import com.akakim.kotlinlib.data.NaverAPIErrorItem
import com.akakim.kotlinlib.data.NaverSearchAPI
import com.akakim.kotlinlib.util.DLog
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.*


/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
class APIManager() {
//    @GET(value="v1/search/local.json")

    val searchAPI = "https://openapi.naver.com/"
    val api = "v1/search/local.json"

    val action = { msg : String -> DLog.d(msg) }

    val naverClientID = "qD8w5T7FSGCfZzuwZfzz"
    val naverClientSecrete ="susq0pojQF"


//    companion object{
//
//        @Volatile private var instance: APIManager? = null
//
//        @JvmStatic fun getInstance(): APIManager =
//            instance ?: synchronized(this) {
//                instance ?: APIManager().also {
//                    instance = it
//                }
//            }
//    }

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
                            val errorItem = Gson().fromJson( charStream(),NaverAPIErrorItem::class.java)

                            Log.d( "onErrorBody", errorItem.toString())

                        }

                        response.body()?.apply {
                            Log.d( "onSuccess", this.category)

                        }
                        naverAPICallback.apiResponseCallback( call , response )

                    }


                })}.run()

    }

   /* @Throws(IOException::class)
    fun getJSONFromFile(context: Context, @RawRes id: Int): String? {
        val inputStream: InputStream = context.getResources().openRawResource(id)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also({ n = it }) != -1) {
                writer.write(buffer, 0, n)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if ( inputStream != null)
                inputStream.close()
        }
        return writer.toString()
    }*/

}