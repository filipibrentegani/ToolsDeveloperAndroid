package com.filipibrentegani.toolsdeveloperandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LeakActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak)
        ActivityLeaker.referenceToLeak = this
    }
}
