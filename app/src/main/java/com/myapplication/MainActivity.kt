package com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.Solutions.getIntArray
import com.myapplication.Solutions.getList1NodeOne
import com.myapplication.Solutions.getList2NodeOne
import com.myapplication.Solutions.lengthOfLastWord
import com.myapplication.Solutions.longestCommonPrefix
import com.myapplication.Solutions.mergeTwoLists
import com.myapplication.Solutions.printAccordingToDivisibility
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
//        result = searchInsert(5).toString()
//        result = lengthOfLastWord("Hello World").toString()
//        result = printAccordingToDivisibility()
//        callByRefOrValue(arrayOf(1,2,3,4,5))
//        val solution = solutionJava()
//        solution.callByValueOrRef()
//        result = Solutions.isValidName().toString()
//        result = Solutions.checkFloatConversion().toString()
        result = MoreSolutions.findEquiInOofN().toString()
//         MoreSolutions.getMaxSum()
        result_tv.text = result
    }
}
