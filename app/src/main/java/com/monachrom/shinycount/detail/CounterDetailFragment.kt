package com.monachrom.shinycount.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.CounterDetailFragmentBinding


class CounterDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            CounterDetailFragment()
    }

    private val viewModel: CounterDetailViewModel by viewModels()
    private val args: CounterDetailFragmentArgs by navArgs()
    private lateinit var binding: CounterDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CounterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textCounterDetail.text = args.counterID.toString()
        super.onViewCreated(view, savedInstanceState)
    }

}
