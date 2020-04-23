package com.monachrom.shinycount.detail

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.monachrom.shinycount.main.data.CounterRepository

class CounterDetailViewModelFactory(
    private val repository: CounterRepository,
    private val counterID: Int
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        return CounterDetailViewModel(repository, counterID) as T
    }
}