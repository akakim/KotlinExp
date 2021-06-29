package com.akakim.inflearn.modern

/*
class variable {
}*/


fun main(){
    var x = 10;
    var str = "Hello"
    var isMarried = true
    var a: Int = 10

    val t = 10
    val items = arrayOf(1,2,3,4,5,6)
    val lstItems = listOf(1,2,3,4,5,6)        // 변수 변경이 불가능하다.
    val mtLstItem = arrayListOf( 1,2,3,4,5,6) // 변수 변경이 가능하다.
    val isEven = if (x%2 ==0 )"짝" else "홀"

    println("$str world")


    mtLstItem.add(7)
    mtLstItem.remove(1)

    println(items)
    println(lstItems)
    println(mtLstItem)

    println("짝 홀 보기")

    println(isEven)
}

fun myMethod(a:Int,b: Int ) : Int{
    return a + b
}
// Unit이 생략되어있음
fun myMethod2(a:Int,b: Int ) {
    print( a+ b )
}

