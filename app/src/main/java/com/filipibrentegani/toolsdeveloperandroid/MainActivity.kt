package com.filipibrentegani.toolsdeveloperandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        show_layout_bounds_button.setOnClickListener {
            startActivity(Intent(this, ShowLayoutBoundsDemonstrationActivity::class.java))
        }
        dont_keep_activities_button.setOnClickListener {
            startActivity(Intent(this, DontKeepActivitiesActivity::class.java))
        }
        leak_button.setOnClickListener {
            startActivity(Intent(this, LeakActivity::class.java))
        }
        debug_button.setOnClickListener {
            anyProcess()
        }
    }

    fun anyProcess() {
        for (i in 0..10) {
            if (i%2==0) {
                evenNumber(i) //par
            } else {
                oddNumber(i) //impar
            }
        }
    }

    fun evenNumber(number: Int){
        Log.i("Filipix", "Número par: $number")
    }

    fun oddNumber(number: Int){
        Log.i("Filipix", "Número impar: $number")
    }

}
