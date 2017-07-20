package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a.setOnClickListener { sendAnalyticsEvent("A") }
        btn_b.setOnClickListener { sendAnalyticsEvent("B") }
        btn_c.setOnClickListener { sendAnalyticsEvent("C") }
    }

    private fun sendAnalyticsEvent(name: String) {
        App.tracker.send(HitBuilders.EventBuilder()
                .setCategory("Category")
                .setAction(name)
                .build())
    }

    override fun onResume() {
        super.onResume()
        sendAnalyticsData()
    }

    private fun sendAnalyticsData() {
        App.tracker.setScreenName("MainActivity Screen")
        App.tracker.send(HitBuilders.ScreenViewBuilder().build())
    }
}