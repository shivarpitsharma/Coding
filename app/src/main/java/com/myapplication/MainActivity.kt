package com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.MoreSolutions.findNeedleInHaystack
import com.myapplication.MoreSolutions.lengthOfLastWord
import com.myapplication.MoreSolutions.plusOne
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var result = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        result = findNeedleInHaystack("needle","le").toString()
//        result = lengthOfLastWord("a ").toString()
        plusOne(array)
        result_tv.text = result
    }
}
