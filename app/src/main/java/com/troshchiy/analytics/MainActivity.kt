package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.troshchiy.analytics.utils.printScreenInfo
import com.troshchiy.analytics.utils.sendFirebaseAction
import kotlinx.android.synthetic.main.main_activity.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        btn_a.setOnClickListener { sendFirebaseAction("Action A") }
        btn_b.setOnClickListener { sendFirebaseAction("Action B") }
        btn_c.setOnClickListener { sendFirebaseAction("Action C") }

        btn_firstActivity.setOnClickListener { startActivity<FirstActivity>() }

        printScreenInfo(this)
    }
}