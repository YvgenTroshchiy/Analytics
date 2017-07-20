package com.troshchiy.analytics

import android.app.Application

class App : Application() {

    companion object {
        lateinit var APP: App
//        lateinit var tracker: Tracker
    }

    init {
        APP = this
    }

    override fun onCreate() {
        super.onCreate()
//        tracker = GoogleAnalytics.getInstance(this).newTracker(R.xml.global_tracker)
    }
}