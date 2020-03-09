package com.monachrom.shinycount.main.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monachrom.shinycount.detail.CounterDetailFragment
import com.monachrom.shinycount.list.ui.CounterFragment

private const val ARG_OBJECT = "object"

class CounterViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment: Fragment = if (position == 0) {
            CounterDetailFragment()
        } else {
            CounterFragment()
        }

        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}
