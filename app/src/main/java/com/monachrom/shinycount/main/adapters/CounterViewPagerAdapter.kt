package com.monachrom.shinycount.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monachrom.shinycount.detail.CounterDetailFragment
import com.monachrom.shinycount.list.ui.CounterListContainerFragment
import com.monachrom.shinycount.list.ui.CounterListFragment

class CounterViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        return if (position == 0) {
            CounterDetailFragment()
        } else {
            CounterListContainerFragment()
        }
    }
}
