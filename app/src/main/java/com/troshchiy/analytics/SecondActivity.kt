package com.troshchiy.analytics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*
import org.jetbrains.anko.toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        btn_completeFunnel.setOnClickListener {
            toast(CompleteFunnelEvents.CompleteFunnel.name)
            logFirebaseEvent(CompleteFunnelEvents.CompleteFunnel)
        }

        logFirebaseEvent(CompleteFunnelEvents.SecondActivity)
    }
}