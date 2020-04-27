package com.monachrom.shinycount.list.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.FragmentCounterListBinding

import com.monachrom.shinycount.dummy.DummyContent
import com.monachrom.shinycount.dummy.DummyContent.DummyItem
import com.monachrom.shinycount.list.adapters.CounterRecyclerViewAdapter
import com.monachrom.shinycount.list.viewmodels.CounterListViewModel
import com.monachrom.shinycount.main.data.Counter
import com.monachrom.shinycount.utilities.InjectorUtils

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [CounterListFragment.OnListFragmentInteractionListener] interface.
 */
class CounterListFragment : Fragment() {

    private lateinit var binding: FragmentCounterListBinding
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private val viewModel: CounterListViewModel by viewModels {
        InjectorUtils.provideCounterListViewModelFactory(requireActivity())
    }
    private val viewAdapter = CounterRecyclerViewAdapter(listener)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterListBinding.inflate(inflater, container, false)

        // Set the adapter
        with(binding.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = viewAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            val action = CounterListFragmentDirections.actionNewCounter()
            findNavController().navigate(action)
        }

        viewModel.counters.observe(viewLifecycleOwner, Observer {
            viewAdapter.values = it
            viewAdapter.notifyDataSetChanged()
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            // throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Counter?) {
            Log.d("TEST", item.toString())
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            CounterListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
