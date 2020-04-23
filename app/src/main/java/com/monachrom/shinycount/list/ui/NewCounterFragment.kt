package com.monachrom.shinycount.list.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.monachrom.shinycount.list.viewmodels.NewCounterViewModel
import com.monachrom.shinycount.R
import com.monachrom.shinycount.databinding.FragmentNewCounterBinding
import com.monachrom.shinycount.utilities.InjectorUtils

class NewCounterFragment : Fragment() {

    companion object {
        fun newInstance() = NewCounterFragment()
    }

    private lateinit var binding: FragmentNewCounterBinding
    private val viewModel: NewCounterViewModel by viewModels {
        InjectorUtils.provideNewCounterViewModelFactory(requireActivity())
    }
    private lateinit var dropdownMenuAdapter: ArrayAdapter<CharSequence>

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
        binding.toolbarNewCounter.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_create_counter -> {
                    Log.d("DEBUG", "hey")
                    viewModel.createNewCounter(
                        binding.textInputName.text.toString(),
                        binding.textInputPokemon.text.toString(),
                        binding.dropdownMenuMethod.text.toString()
                    )
                    val action = NewCounterFragmentDirections.actionCounterCreated()
                    findNavController().navigate(action)
                    true
                }

                else -> {
                    super.onOptionsItemSelected(it)
                }
            }
        }
        return binding.root
    }
}
