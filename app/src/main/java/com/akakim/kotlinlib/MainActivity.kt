package com.akakim.kotlinlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akakim.kotlinlib.adapter.ActivityAdapter
import com.akakim.kotlinlib.adapter.ActivityItem
import com.akakim.kotlinlib.adapter.OnClickListener
import com.akakim.kotlinlib.ui.*
import com.akakim.kotlinlib.ui.naver.*

class MainActivity : AppCompatActivity(), OnClickListener {

    val sampleList : MutableList<ActivityItem>
    lateinit var rvMain : RecyclerView

    init {
        sampleList = mutableListOf()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvMain = findViewById( R.id.rvMain)

        rvMain.adapter = ActivityAdapter( this ,sampleList)
        rvMain.layoutManager= LinearLayoutManager(this)

        sampleList.add(  ActivityItem( Intent( this@MainActivity,NaverAPIInfoActivity::class.java) ,"네이버 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this@MainActivity,KakaoSampleActivity::class.java) ,"카카토 맵 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this@MainActivity, SampleListActivity::class.java) ,"네이버 CloudPlatform 샘플 목록") )

    }

    override fun onClickITem(item: ActivityItem) {

        startActivity( item.activityIntent )
    }
}