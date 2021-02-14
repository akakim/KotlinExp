package com.akakim.kotlinlib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.akakim.kotlinlib.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar( tBar )

        supportActionBar?.setDisplayHomeAsUpEnabled( true )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            (android.R.id.home)->{
                  finish()
                return true
            }

        }


        return super.onOptionsItemSelected(item)
    }
}