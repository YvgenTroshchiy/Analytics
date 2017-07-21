package com.troshchiy.analytics

import android.app.Application

class App : Application() {

    companion object {
        lateinit var APP: App
    }

    init {
        APP = this
    }
}