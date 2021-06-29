package com.akakim.kotlinlib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.akakim.kotlinlib.R
import com.akakim.kotlinlib.data.NaverSearchAPI
import com.akakim.kotlinlib.network.APICallback
import com.akakim.kotlinlib.network.APIManager
import retrofit2.Call
import retrofit2.Response

class NaverAPIInfoActivity : AppCompatActivity(), APICallback {

    lateinit var tvResult : AppCompatTextView
    lateinit var apiManager : APIManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_naver_api_info)

        apiManager= APIManager()
        findViewById<AppCompatButton>(R.id.btnMain).setOnClickListener {

            apiManager.naverAPISearch( this )
//            if( APIManager.getInstance() == null ){
//                tvResult.text="API Manger 초기화 실패 "
//                APIManager.getInstance()
//            }else {
//                APIManager.getInstance().naverAPISearch(this)
//            }
        }

        tvResult = findViewById<AppCompatTextView>(R.id.tvResult)
    }

    override fun apiResponseCallback(
        call: Call<NaverSearchAPI>,
        response: Response<NaverSearchAPI>
    ) {
        tvResult.text = response.body().toString()

    }

    override fun apiError(call: Call<NaverSearchAPI>, t: Throwable) {
        Log.e( "apiError" , "error")
    }
}