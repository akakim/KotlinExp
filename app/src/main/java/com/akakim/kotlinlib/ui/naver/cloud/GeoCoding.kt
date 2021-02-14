package com.akakim.kotlinlib.ui.naver.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akakim.kotlinlib.R
import com.akakim.kotlinlib.network.APIManager
import com.akakim.kotlinlib.network.naver.GeoManager

class GeoCoding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_coding)

        val manager = GeoManager()
        manager.host = "https://naveropenapi.apigw.ntruss.com"
    }
}