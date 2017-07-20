package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        btn_a.setOnClickListener {
            sendFirebaseEvent("Firebase A")
            sendAnalyticsEvent("Analytics A")
        }
        btn_b.setOnClickListener {
            sendFirebaseEvent("Firebase B")
            sendAnalyticsEvent("Analytics B")
        }
        btn_c.setOnClickListener {
            sendFirebaseEvent("Firebase C")
            sendAnalyticsEvent("Analytics C")
        }
    }

    private fun sendFirebaseEvent(name: String) {
        val bundle = Bundle()
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "type")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    private fun sendAnalyticsEvent(name: String) {
        App.tracker.send(HitBuilders.EventBuilder()
                .setCategory("Category")
                .setAction(name)
                .build())
    }

    override fun onResume() {
        super.onResume()
        sendFirebaseEvent("Firebase MainActivity Screen")
        sendAnalyticsData()
    }

    private fun sendAnalyticsData() {
        App.tracker.setScreenName("MainActivity Screen")
        App.tracker.send(HitBuilders.ScreenViewBuilder().build())
    }
}