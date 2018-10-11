package com.sikling.app.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sikling.app.R

class SearchActivity : AppCompatActivity() {
    companion object {
        fun launch(context: Context) {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context.startActivity(searchIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
