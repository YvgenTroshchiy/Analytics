package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tracker = App.APP.getDefaultTracker()
        tracker?.setScreenName("MainActivity")
        tracker?.send(HitBuilders.ScreenViewBuilder().build())

        tracker?.send(HitBuilders.EventBuilder()
                .setCategory("Category")
                .setAction("Action")
                .build())
    }
}