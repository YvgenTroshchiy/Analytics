package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.main_activity.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        btn_firstActivity.setOnClickListener { startActivity<FirstActivity>() }

        logFirebaseEvent(CompleteFunnelEvents.MainActivity)

        btn_a.setOnClickListener { sendFirebaseEvent("A") }
        btn_b.setOnClickListener { sendFirebaseEvent("B") }
        btn_c.setOnClickListener { sendFirebaseEvent("C") }
    }

    private fun sendFirebaseEvent(name: String) {
        val bundle = Bundle()
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button")
        App.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
}