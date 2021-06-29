package com.akakim.kotlinlib.inflearn

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akakim.kotlinlib.data.Todo
import com.akakim.kotlinlib.data.TodoDao


@Database(entities = [Todo::class],version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun todoDao(): TodoDao
}