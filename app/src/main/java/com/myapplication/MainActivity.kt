package com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.MoreSolutions.findNeedleInHaystack
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var result = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findNeedleInHaystack().toString()
        result_tv.text = result
    }
}
