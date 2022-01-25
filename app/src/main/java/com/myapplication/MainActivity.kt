package com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.SolutionsPartTwoKotlin.majorityElement

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intArray = IntArray(3)
        intArray[0] = 3
        intArray[1] = 2
        intArray[2] = 3


        majorityElement(intArray)
    }
}
