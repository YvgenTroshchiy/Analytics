package com.troshchiy.analytics

import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker

class App : Application() {

    companion object {
        lateinit var APP: App
        lateinit var tracker: Tracker
    }

    init {
        APP = this
    }

    override fun onCreate() {
        super.onCreate()
        tracker = GoogleAnalytics.getInstance(this).newTracker(R.xml.global_tracker)
    }
}