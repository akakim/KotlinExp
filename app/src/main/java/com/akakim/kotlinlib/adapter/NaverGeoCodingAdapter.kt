package com.akakim.kotlinlib.adapter

//import android.content.res.TypedArray
import com.akakim.kotlinlib.data.NaverGeoCoding
import com.akakim.kotlinlib.network.naver.GeoAPICallback
import com.google.gson.annotations.JsonAdapter
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

/**
 * SerializedName Annotation만으로는 해결이 안되는 경우
 * Adatper를 이용하엿다.
 */
class NaverGeoCodingAdapter() : TypeAdapter<NaverGeoCoding>(){

    override fun write(jsonOut: JsonWriter?, value: NaverGeoCoding?) {
        /**
         * 이 클래스를 write 하는경우 여기다가 작성하면된다.
         */
    }

    override fun read(jsonIn: JsonReader?): NaverGeoCoding {

        jsonIn?.apply {
            beginObject()
            nextString()


            endObject()

        }

        return NaverGeoCoding(

        )
    }
}