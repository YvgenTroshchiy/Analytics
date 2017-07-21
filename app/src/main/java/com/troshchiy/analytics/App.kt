package com.troshchiy.analytics

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics

class App : Application() {

    companion object {
        lateinit var APP: App
        lateinit var firebaseAnalytics: FirebaseAnalytics
    }

    init {
        APP = this
    }

    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }
}