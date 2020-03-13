package com.monachrom.shinycount.list.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.FragmentCounterListBinding
import com.monachrom.shinycount.databinding.FragmentCounterListContainerBinding

/**
 * A simple [Fragment] subclass.
 */
class CounterListContainerFragment : Fragment() {

    private lateinit var binding: FragmentCounterListContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterListContainerBinding.inflate(inflater, container, false)
        return binding.root
    }
}
