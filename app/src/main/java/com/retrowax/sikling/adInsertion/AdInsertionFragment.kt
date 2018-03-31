package com.retrowax.sikling.adInsertion

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.retrowax.sikling.R


class AdInsertionFragment(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_ad_insertion, container, false)
    }
}