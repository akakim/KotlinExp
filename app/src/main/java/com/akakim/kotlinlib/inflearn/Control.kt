package com.akakim.kotlinlib.inflearn


fun main(){

    var x = 10
    val isEven = if (x%2 ==0 )"짝" else "홀"
    println("짝 홀 보기")

    println(isEven)

    for ( i in 0..40){


        when ( i ){
            1->println("$i 입니다.")
            3,4,5->println("3,4,5 중 하나입니다. ")
            in 6..20->println("6~20 사이 입니다.")
            !in 30..40 ->println("")
            else ->println("$i 입니다")
        }
    }

}