package com.myapplication

/**
 * Created by Shivarpit
 */

abstract class BaseNumber<T> {
    abstract fun add(a: T, b: T): T

    fun printSum(a: T, b: T) {
        System.out.println(add(a, b).toString())
    }
}

class IntegerSum : BaseNumber<Int>() {
    override fun add(a: Int, b: Int): Int {
        return a + b;
    }

    fun print() {
        printSum(10, 6);
    }
}


class FloatSum : BaseNumber<Float>() {
    override fun add(a: Float, b: Float): Float {
        return a + b;
    }

    fun print() {
        printSum(10f, 6f);
    }
}

class StringSum : BaseNumber<String>() {
    override fun add(a: String, b: String): String {
        return a + b
    }

    fun print() {
        printSum("hello", "world")
    }

}