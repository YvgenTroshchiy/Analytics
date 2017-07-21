package com.troshchiy.analytics

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.startActivity

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.first_fragment, container, false)

        setCurrentScreen(activity, this.javaClass.simpleName)

        view?.findViewById(R.id.btn_openSecondActivity)?.setOnClickListener { startActivity<SecondActivity>() }
        return view
    }
}