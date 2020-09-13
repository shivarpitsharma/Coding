package com.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.myapplication.MoreSolutions.findEquiInOofN
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var result = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToggle()
        setClickListener()
//        result = findNeedleInHaystack("needle","le").toString()
//        result = lengthOfLastWord("a ").toString()
//        plusOne(array)
        result = findEquiInOofN().toString()
        result_tv.text = result
    }

    private fun setToggle() {
        toggle1.isActivated = when (resources.configuration.uiMode) {
            Configuration.UI_MODE_NIGHT_NO -> false
            // Night mode is not active, we're in day time
            Configuration.UI_MODE_NIGHT_YES -> true
            // Night mode is active, we're at night!
            Configuration.UI_MODE_NIGHT_UNDEFINED -> false
            // We don't know what mode we're in, assume notnight
            else -> false
        }
    }

    private fun setClickListener() {
        toggle1.setOnClickListener {
            with(toggle1) {
                if (this.isActivated) {
                    this.isActivated = false
                    AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )
                } else {
                    this.isActivated = true
                    AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES
                    )
                }
            }
        }
    }
}
