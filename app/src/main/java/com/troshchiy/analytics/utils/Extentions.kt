package com.troshchiy.analytics.utils

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.troshchiy.analytics.App

fun sendFirebaseAction(name: String) {
    val params = Bundle()
    params.putString("name", name)
    FirebaseAnalytics.getInstance(App.APP).logEvent("action", params)
}

fun sendScreenFirebaseEvent(name: String) {
    val params = Bundle()
    params.putString("name", name)
    FirebaseAnalytics.getInstance(App.APP).logEvent("screen", params)
}