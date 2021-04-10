package com.utu.weatherapp.adapter


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.utu.weatherapp.data.Model.ui.Fragments.HobartFragment
import com.utu.weatherapp.data.Model.ui.Fragments.MelbourneFragment
import com.utu.weatherapp.data.Model.ui.Fragments.PerthFragment
import com.utu.weatherapp.data.Model.ui.Fragments.SydneyFragment

class FragmentPagerAdapter(activity: AppCompatActivity, val itemsCount: Int) :
        FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            MelbourneFragment()
        } else if (position == 1) {
            HobartFragment()
        } else if(position == 2) {
            PerthFragment()
        }else{
            SydneyFragment()
        }
    }
}