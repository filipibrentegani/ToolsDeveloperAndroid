package com.filipibrentegani.toolsdeveloperandroid

import android.app.Activity

object ActivityLeaker {
    var referenceToLeak: Activity? = null
}