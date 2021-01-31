package com.akakim.kotlinlib.adapter

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-30
 */
data class ActivityItem(
    val activityIntent: Intent,
    val description: String
){

}