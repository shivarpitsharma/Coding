package com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.Solutions.getIntArray
import com.myapplication.Solutions.getList1NodeOne
import com.myapplication.Solutions.getList2NodeOne
import com.myapplication.Solutions.longestCommonPrefix
import com.myapplication.Solutions.mergeTwoLists
import com.myapplication.Solutions.removeDuplicates
import com.myapplication.Solutions.reverseInteger
import com.myapplication.Solutions.romanToInt
import com.myapplication.Solutions.searchInsert
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var result = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        result = reverseInteger(-1534236469).toString()
//        result = romanToInt("IV").toString()
//        result = longestCommonPrefix(arrayOf("flower","floor","flour")).toString()
//        result = Solutions.isValid("{[]}").toString()
//        result = mergeTwoLists(getList1NodeOne(),getList2NodeOne()).toString()
//        result = removeDuplicates(getIntArray()).toString()
        val intArray = IntArray(4)
        intArray[0]=1
        intArray[1]=3
        intArray[2]=5
        intArray[3]=6
        result = searchInsert(intArray,5).toString()
        result_tv.text = result
    }
}
