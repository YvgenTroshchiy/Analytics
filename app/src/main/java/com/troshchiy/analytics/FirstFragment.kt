package com.troshchiy.analytics

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.analytics.FirebaseAnalytics
import com.troshchiy.analytics.utils.sendScreenFirebaseEvent
import org.jetbrains.anko.startActivity

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.first_fragment, container, false)

        sendScreenEvent()

        view?.findViewById(R.id.btn_openSecondActivity)?.setOnClickListener { startActivity<SecondActivity>() }
        return view
    }

    private fun sendScreenEvent() {
        val screenName = this.javaClass.simpleName

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            FirebaseAnalytics.getInstance(context).setCurrentScreen(activity, screenName, null /* class override */)
        }

        sendScreenFirebaseEvent(screenName)
    }
}