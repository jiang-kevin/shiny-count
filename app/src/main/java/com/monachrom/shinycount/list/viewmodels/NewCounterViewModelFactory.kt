package com.monachrom.shinycount.list.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monachrom.shinycount.main.data.CounterRepository

class NewCounterViewModelFactory(
    private val repository: CounterRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewCounterViewModel(repository) as T
    }
}