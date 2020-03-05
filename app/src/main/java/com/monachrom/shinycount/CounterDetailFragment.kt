package com.monachrom.shinycount

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.monachrom.shinycount.ui.main.MainViewModel


class CounterDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CounterDetailFragment()
    }

    private lateinit var viewModel: CounterDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.counter_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CounterDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
