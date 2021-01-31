package com.akakim.kotlinlib.network.serialize

import com.akakim.kotlinlib.data.NaverSearchAPI
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
//
//open class NaverSerializer: JsonDeserializer<NaverSearchAPI>{
//
//    override fun deserialize(
//        json: JsonElement?,
//        typeOfT: Type?,
//        context: JsonDeserializationContext?
//    ): NaverSearchAPI {
//
//        val jsonObject = json?.asJsonObject
//
////        if (jsonObject != null ) {
////            val minimumInterviews   = jsonObject.get("minimum_interviews")?.asInt
////            val totalPage           = jsonObject.get("total_page")?.asInt
////            val minimumReviews      = jsonObject.get("minimum_reviews")?.asInt
////            val totalCount          = jsonObject.get("total_count")?.asInt
////            val page: Int?          = jsonObject.get("page").asInt
////            val pageSize: Int?      = jsonObject.get("page_size").asInt
////            val minimumSalaries     = jsonObject.get("minimum_salaries").asInt
////        }
//    }
//}