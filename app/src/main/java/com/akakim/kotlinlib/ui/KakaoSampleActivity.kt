package com.akakim.kotlinlib.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.akakim.kotlinlib.R
import net.daum.android.map.MapView


class KakaoSampleActivity : AppCompatActivity() {

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("libDaumMapEngineApi")

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kakao)

        val mapView = MapView(this)

        val mapViewContainer = findViewById(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)
    }


}