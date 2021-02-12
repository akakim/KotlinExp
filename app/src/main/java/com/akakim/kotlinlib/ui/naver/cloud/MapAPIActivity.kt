package com.akakim.kotlinlib.ui.naver.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.akakim.kotlinlib.R
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Marker

class MapAPIActivity : AppCompatActivity(),OnMapReadyCallback {

    val lat = 37.5670135
    val longtitute = 126.9783740

    var map : Fragment? = null

    lateinit var naverMap: NaverMap
//    lateinit var naver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_api)

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient("mzygclbe90")

//        NaverMapSdk.getInstance(this).
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance()

        mapFragment.getMapAsync (this)




    }

    //reference https://navermaps.github.io/android-map-sdk/guide-ko/2-3.html
    // 마커와 관련된 문서 https://navermaps.github.io/android-map-sdk/guide-ko/5-2.html
    // 주위 표시를 위해서는 https://navermaps.github.io/android-map-sdk/guide-ko/5-5.html 를 참고하여야한다.

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        this.naverMap.symbolScale = 2f
        this.naverMap.isLiteModeEnabled = true

        val marker = Marker().apply {
            position = LatLng(lat,longtitute )
            setOnClickListener {
                Toast.makeText(this@MapAPIActivity, "마커 클릭됨", Toast.LENGTH_SHORT).show()
                true
            }

        }

        marker.map = naverMap
        marker.width = Marker.SIZE_AUTO
        marker.height = Marker.SIZE_AUTO

        val infoWindow = InfoWindow()
        infoWindow.adapter = object : InfoWindow.DefaultTextAdapter(this) {
            override fun getText(infoWindow: InfoWindow): CharSequence {
                return "정보 창 내용"
            }
        }

        infoWindow.position = LatLng(lat,longtitute)
        infoWindow.open(naverMap)
//        infoWindow.open(marker)
//        infoWindow.open(naverMap)

    }
}