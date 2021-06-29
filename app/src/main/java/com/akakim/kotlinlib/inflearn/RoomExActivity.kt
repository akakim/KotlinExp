package com.akakim.kotlinlib.inflearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.room.Room
import com.akakim.kotlinlib.R
import com.akakim.kotlinlib.data.Todo

class RoomExActivity : AppCompatActivity() {

    lateinit var tvTop : AppCompatTextView
    lateinit var btnAdd : AppCompatButton
    lateinit var edTODO : AppCompatEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_ex)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"todoDB"
        ).build()

        tvTop.text= db.todoDao().getAll().toString()

        btnAdd.setOnClickListener{
            db.todoDao().insert(Todo(edTODO.text.toString()))
            tvTop.text= db.todoDao().getAll().toString()
        }
    }
}