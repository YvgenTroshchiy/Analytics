package com.troshchiy.analytics.utils

import android.app.Activity
import android.util.DisplayMetrics

fun printScreenInfo(activity: Activity) {
    val TAG = "SCREEN"

    val dm = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(dm)

    val scaleFactor = dm.density
    val widthPixels = dm.widthPixels
    val heightPixels = dm.heightPixels

    val widthDp = widthPixels / scaleFactor
    val heightDp = heightPixels / scaleFactor
    val smallestWidth = Math.min(widthDp, heightDp)

    logW(TAG, "density (scaleFactor): $scaleFactor ")

    when (scaleFactor) {
        0.75f -> logW(TAG, "ldpi")
        1.0f -> logW(TAG, "mdpi")
        1.5f -> logW(TAG, "hdpi")
        2.0f -> logW(TAG, "xhdpi")
        3.0f -> logW(TAG, "xxhdpi")
        4.0f -> logW(TAG, "xxxhdpi")
    }

    logW(TAG, "widthPixels: $widthPixels, heightPixels: $heightPixels")
    logW(TAG, "xdpi: ${dm.xdpi}, ydpi: ${dm.ydpi}")
    logW(TAG, "widthDp: $widthDp, heightDp: $heightDp")
    logW(TAG, "sw: $smallestWidth")
    logW(TAG, "densityDpi: " + dm.densityDpi)

    val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
    val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
    val screenInches = Math.sqrt(x + y)
    logW(TAG, "screenInches: $screenInches")

    if (smallestWidth > 600) logW(TAG, "Device is a 7 table")
    else if (smallestWidth > 720) logW(TAG, "Device is a 10 table")
}