package com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var result = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result_tv.text = result
    }
}
