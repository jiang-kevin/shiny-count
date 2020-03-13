package com.monachrom.shinycount

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class NewCounterFragment : Fragment() {

    companion object {
        fun newInstance() = NewCounterFragment()
    }

    private lateinit var viewModel: NewCounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_counter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewCounterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
