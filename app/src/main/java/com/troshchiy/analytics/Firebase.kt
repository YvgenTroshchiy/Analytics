package com.troshchiy.analytics

import android.app.Activity
import android.os.Bundle

enum class CompleteFunnelEvents { MainActivity, FirstActivity, SecondActivity, CompleteFunnel }

fun logScreenInFirebase(activity: Activity, screenName: String) =
        App.firebaseAnalytics.setCurrentScreen(activity, screenName, null /* class override */)

fun logFirebaseEvent(eventName: CompleteFunnelEvents, key: String = "name", value: String = "") =
        logFirebaseEvent(eventName.name, key, value)

fun logFirebaseEvent(eventName: String, key: String = "name", value: String = "") {
    val params = Bundle()
    params.putString(key, value)
    App.firebaseAnalytics.logEvent(eventName, params)
}