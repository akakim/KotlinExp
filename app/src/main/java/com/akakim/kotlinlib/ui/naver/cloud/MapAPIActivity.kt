package com.akakim.kotlinlib.ui.naver.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akakim.kotlinlib.R
import com.naver.maps.map.NaverMapSdk

class MapAPIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_api)

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient("mzygclbe90")


    }
}