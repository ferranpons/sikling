package com.sikling.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.internal.BottomNavigationItemView
import androidx.navigation.Navigation.findNavController
import com.sikling.app.adInsertion.AdInsertionFragment
import com.sikling.app.adListing.AdListingFragment
import com.sikling.app.favorites.FavoritesFragment
import com.sikling.app.messaging.MessagingFragment
import com.sikling.app.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.navigation

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
        disableMenuShiftingMode()
    }

    override fun onSupportNavigateUp()
            = findNavController(this, R.id.content_frame).navigateUp()

    @SuppressLint("RestrictedApi")
    private fun disableMenuShiftingMode() {
        val menuView = navigation.getChildAt(0) as BottomNavigationMenuView
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (i in 0 until menuView.childCount) {
            val itemView = menuView.getChildAt(i) as BottomNavigationItemView
            itemView.setShiftingMode(false)
            itemView.setChecked(false)
        }
    }
}
