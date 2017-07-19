package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a.setOnClickListener { }
        btn_b.setOnClickListener { }
        btn_c.setOnClickListener { }

        sendAnalyticsData()
    }

    private fun sendAnalyticsData() {
        App.tracker.setScreenName("MainActivity Screen")
        App.tracker.send(HitBuilders.ScreenViewBuilder().build())

        App.tracker.send(HitBuilders.EventBuilder()
                .setCategory("Category")
                .setAction("Action")
                .build())
    }
}