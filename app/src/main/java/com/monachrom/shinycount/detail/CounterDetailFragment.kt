package com.monachrom.shinycount.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.FragmentCounterDetailBinding
import com.monachrom.shinycount.utilities.InjectorUtils


class CounterDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            CounterDetailFragment()
    }

    private val args: CounterDetailFragmentArgs by navArgs()
    private val viewModel: CounterDetailViewModel by viewModels {
        InjectorUtils.provideCounterDetailViewModelFactory(requireActivity(), args.counterID)
    }
    private lateinit var binding: FragmentCounterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.counter.observe(viewLifecycleOwner, Observer {
            with(binding) {
                toolbarCounterDetail.title = it.name
                textCounterPokemon.text = it.pokemon
                textCounterCount.text = it.count.toString()
                textCounterMethod.text = it.method
                textCounterStartDate.text = it.startDate.toString()
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }

}
