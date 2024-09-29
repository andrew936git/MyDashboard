package com.example.mydashboard.viewpager2

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment, val viewPagerList: MutableList<Picture>):
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return viewPagerList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerFragment()
        fragment.arguments = bundleOf("picture" to viewPagerList[position])
        return fragment
    }
}