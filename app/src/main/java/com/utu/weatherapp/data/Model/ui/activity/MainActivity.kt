package com.utu.weatherapp.data.Model.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.utu.weatherapp.R
import com.utu.weatherapp.ViewModel.MainViewModel
import com.utu.weatherapp.adapter.FragmentPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(
            savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<View>(
                R.id.viewpager) as ViewPager2

        val adapter = FragmentPagerAdapter(
                this, 4)

        viewPager.adapter = adapter

        val tabLayout = findViewById<View>(R.id.tab_layout) as TabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        }.attach()
    }
}