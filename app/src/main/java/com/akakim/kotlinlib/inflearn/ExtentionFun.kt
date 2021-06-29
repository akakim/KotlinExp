package com.akakim.kotlinlib.inflearn

fun main(){
    val str = "Hello"
    print( str.myLength())
}

fun String.myLength():Int{
    return this.length
}