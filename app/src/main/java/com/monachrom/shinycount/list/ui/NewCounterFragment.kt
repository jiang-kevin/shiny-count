package com.monachrom.shinycount.list.ui

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.monachrom.shinycount.list.viewmodels.NewCounterViewModel
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.FragmentNewCounterBinding

val METHODS = arrayOf("Masuda Method", "Wild Encounter")

class NewCounterFragment : Fragment() {

    companion object {
        fun newInstance() = NewCounterFragment()
    }

    private lateinit var binding: FragmentNewCounterBinding
    private val viewModel: NewCounterViewModel by viewModels()
    private lateinit var dropdownMenuAdapter: ArrayAdapter<CharSequence>

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_create_counter -> {

            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewCounterBinding.inflate(inflater, container, false)
        dropdownMenuAdapter = ArrayAdapter.createFromResource(
            binding.root.context,
            R.array.methods_array,
            R.layout.dropdown_menu_method_item)
        binding.dropdownMenuMethod.setAdapter(dropdownMenuAdapter)
        binding.toolbarNewCounter.inflateMenu(R.menu.menu_new_counter)
        return binding.root
    }
}
