package com.sikling.app

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.sikling.app.adInsertion.AdInsertionFragment
import com.sikling.app.adListing.AdListingFragment
import com.sikling.app.favorites.FavoritesFragment
import com.sikling.app.messaging.MessagingFragment
import com.sikling.app.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, AdListingFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorites -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, FavoritesFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ad_insertion -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, AdInsertionFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, MessagingFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, ProfileFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }
}