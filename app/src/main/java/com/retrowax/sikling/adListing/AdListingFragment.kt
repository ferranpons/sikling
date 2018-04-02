package com.retrowax.sikling.adListing

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.retrowax.sikling.R

class AdListingFragment: Fragment() {

    private val list = ArrayList<AdListingModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 1..60) {
            list.add(AdListingModel("1",
                    "Specialized Camber 29\"",
                    "1700$",
                    "https://cdnmos-bikeradar.global.ssl.fastly.net/images/bikes-and-gear/bikes/mountain-bikes/full-suspension/1450438156130-1116hp2rz2x3x-1260-80.jpg",
                    "20 sept 2016",
                    false))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_ad_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val recyclerView = view.findViewById<RecyclerView>(R.id.ad_listing_recyclerview)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        val adListingAdapter = AdListingAdapter()
        adListingAdapter.addAds(list)
        recyclerView.adapter = adListingAdapter
    }
}