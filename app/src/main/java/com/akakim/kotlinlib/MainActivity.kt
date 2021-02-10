package com.akakim.kotlinlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akakim.kotlinlib.adapter.ActivityAdapter
import com.akakim.kotlinlib.adapter.ActivityItem
import com.akakim.kotlinlib.adapter.OnClickListener
import com.akakim.kotlinlib.ui.KakaoSampleActivity
import com.akakim.kotlinlib.ui.NaverAPIInfoActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    val sampleList : MutableList<ActivityItem>

    init {
        sampleList = mutableListOf()
    }

    lateinit var rvMain : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sampleList.add(  ActivityItem( Intent( this,NaverAPIInfoActivity::class.java) ,"네이버 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this,KakaoSampleActivity::class.java) ,"카카토 맵 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this,NaverAPIInfoActivity::class.java) ,"bbbb 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this,NaverAPIInfoActivity::class.java) ,"cccc 테스트 화면") )
        sampleList.add(  ActivityItem( Intent( this,NaverAPIInfoActivity::class.java) ,"네이버 테스트 화면") )

        rvMain = findViewById( R.id.rvMain)

        rvMain.adapter = ActivityAdapter( this ,sampleList)
        rvMain.layoutManager= LinearLayoutManager(this)

    }

    override fun onClickITem(item: ActivityItem) {

        startActivity( item.activityIntent )
    }
}