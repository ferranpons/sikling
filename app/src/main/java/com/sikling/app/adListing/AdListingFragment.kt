package com.sikling.app.adListing

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.sikling.app.R
import com.sikling.app.search.SearchActivity
import java.security.SecureRandom

class AdListingFragment : Fragment() {

    private val list = ArrayList<AdListingModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addDummyRandomContent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_ad_listing, container, false)
        setupToolBar(view)
        return view
    }

    private fun setupToolBar(view: View) {
        val toolBar = view.findViewById<Toolbar>(R.id.toolbar)
        toolBar.inflateMenu(R.menu.ad_listing_menu)
        toolBar.setOnMenuItemClickListener { item -> onMenuClicked(item) }
    }

    private fun onMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_search -> SearchActivity.launch(activity)
        }
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        val recyclerView = view.findViewById<RecyclerView>(R.id.ad_listing_recyclerview)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        val adListingAdapter = AdListingAdapter()
        adListingAdapter.addAds(list)
        recyclerView.adapter = adListingAdapter
    }

    private fun addDummyRandomContent() {
        for (i in 1..60) {
            when (SecureRandom().nextInt(10)) {
                0 -> {
                    list.add(AdListingModel("0",
                            "Specialized Camber 29\"",
                            "1700$",
                            "https://cdnmos-bikeradar.global.ssl.fastly.net/images/bikes-and-gear/bikes/mountain-bikes/full-suspension/1450438156130-1116hp2rz2x3x-1260-80.jpg",
                            "20 sept 2016",
                            false))
                }
                1 -> {
                    list.add(AdListingModel("1",
                            "Commencal Meta Power Essential Mango 2018\"",
                            "4.499,00 €",
                            "https://thumbnails.emtb-news.de/cache/2400_1280_1_1_0/b2/aHR0cHM6Ly93d3cuZW10Yi1uZXdzLmRlL25ld3Mvd3AtY29udGVudC91cGxvYWRzLzIwMTcvMDgvYUhSMGNITTZMeTltYzNSaGRHbGpNUzVsYlhSaUxXNWxkM011WkdVdmRqTXZNQzgxTHpVNE1Ea3RlV2QzTm5WNFlXMWtjbUZpTFY5a2MyTTROVFF6TFc5eWFXZHBibUZzTG1wd1p3LmpwZw.jpg",
                            "20 sept 2016",
                            false))
                }
                2 -> {
                    list.add(AdListingModel("2",
                            "Santa Cruz V10 C Zee",
                            "4.899$",
                            "https://cdnmos-bikeradar.global.ssl.fastly.net/images/bikes-and-gear/bikes/mountain-bikes/full-suspension/santa-cruz-v10-c-zee-pack-01-1461579826893-1vx8fcs3wt0hk-1260-80.jpg",
                            "20 sept 2016",
                            false))
                }
                3 -> {
                    list.add(AdListingModel("3",
                            "MONDRAKER SUMMUM CARBON",
                            "3850$",
                            "https://www.mtb-mag.com/wp-content/uploads/2016/07/IMG_5588.jpg",
                            "20 sept 2016",
                            false))
                }
                4 -> {
                    list.add(AdListingModel("4",
                            "BH Lynx 8",
                            "2550$",
                            "http://www.ruedasgordas.es/uploads/images/11905745_985945934770539_8241778863584186060_n.jpg",
                            "20 sept 2016",
                            false))
                }
                5 -> {
                    list.add(AdListingModel("5",
                            "Trek Full Stach 8",
                            "3990$",
                            "http://www.ruedasgordas.es/uploads/images/image-FullStache8_22688_A_Portrait.jpg",
                            "20 sept 2016",
                            false))
                }
                6 -> {
                    list.add(AdListingModel("6",
                            "Privee SHAN 5",
                            "1850$",
                            "http://www.ruedasgordas.es/uploads/images/image-shan_5.jpg",
                            "20 sept 2016",
                            false))
                }
                7 -> {
                    list.add(AdListingModel("7",
                            "Rocky Mountain Thunderbolt",
                            "4433$",
                            "http://www.ruedasgordas.es/uploads/images/image-RMB_AV_BCEdition-1966.jpg",
                            "20 sept 2016",
                            false))
                }
                8 -> {
                    list.add(AdListingModel("8",
                            "Devinci Wilson 29 DH",
                            "3234$",
                            "http://www.ruedasgordas.es/uploads/images/image-devince_wilson_29.jpg",
                            "20 sept 2016",
                            false))
                }
                9 -> {
                    list.add(AdListingModel("9",
                            "YT Capra 2018",
                            "5199$",
                            "http://www.ruedasgordas.es/uploads/images/image-p5pb15586130.jpg",
                            "20 sept 2016",
                            false))
                }
            }
        }
    }
}