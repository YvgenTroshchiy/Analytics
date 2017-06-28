package com.troshchiy.analytics

import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker

class App : Application() {

    companion object {
        lateinit var APP: App
        lateinit var analytics: GoogleAnalytics
        private var tracker: Tracker? = null
    }

    init {
        APP = this
        analytics = GoogleAnalytics.getInstance(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    @Synchronized fun getDefaultTracker(): Tracker? {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (tracker == null) {
            tracker = analytics.newTracker(R.xml.global_tracker)
        }

        return tracker
    }
}