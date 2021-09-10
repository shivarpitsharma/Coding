package com.myapplication

//import com.myapplication.MoreSolutions.checkletandrunreturn
import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.myapplication.MoreSolutions.add
import com.myapplication.MoreSolutions.checkPhoneCode
import com.myapplication.MoreSolutions.coroutineChannels
import com.myapplication.MoreSolutions.new
import com.myapplication.MoreSolutions.printList
import com.myapplication.Solutions.getFileName
import com.myapplication.Solutions.getNew
import com.myapplication.solutionJava.hello
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var result: String? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val a = "a"
        result_tv.text = "${a[0].uppercase()}${a.substring(1).lowercase()}"



        CoroutineScope(Dispatchers.Default).launch {
            new()
            Log.e("Coroutine Default", "Default 1: ${Thread.currentThread().name}")
        }
    }


    suspend fun new(){
        withContext(Dispatchers.Default){
            Log.e("Coroutine Default", "Default 2: ${Thread.currentThread().name}")

        }
    }
}
