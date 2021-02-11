package com.akakim.kotlinlib.ui.naver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akakim.kotlinlib.R
import com.akakim.kotlinlib.adapter.ActivityAdapter
import com.akakim.kotlinlib.adapter.ActivityItem
import com.akakim.kotlinlib.adapter.OnClickListener
import com.akakim.kotlinlib.ui.naver.cloud.MapAPIActivity
import com.akakim.kotlinlib.ui.naver.cloud.SearchAPIActivity

class SampleListActivity : AppCompatActivity() , OnClickListener {
    val sampleList : MutableList<ActivityItem>
    lateinit var rvCloudSample : RecyclerView

    init {
        sampleList = mutableListOf()


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_naver_sample_list)
        rvCloudSample = findViewById(R.id.rvCloudSample)

        rvCloudSample.adapter = ActivityAdapter( this ,sampleList)
        rvCloudSample.layoutManager= LinearLayoutManager(this)

        sampleList.add(  ActivityItem( Intent( this, MapAPIActivity::class.java) ,"네이버 맵 API ") )
        sampleList.add(  ActivityItem( Intent( this, SearchAPIActivity::class.java) ,"서칭 API") )

    }

    override fun onClickITem(item: ActivityItem) {
        startActivity( item.activityIntent )
    }
}