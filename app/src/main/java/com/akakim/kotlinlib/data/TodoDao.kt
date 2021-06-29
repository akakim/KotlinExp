package com.akakim.kotlinlib.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

import java.util.List
@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getAll() : List<Todo>

    @Insert
    fun insert(todo : Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo:Todo)


}