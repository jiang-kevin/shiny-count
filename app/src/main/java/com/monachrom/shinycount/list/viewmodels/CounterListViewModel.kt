package com.monachrom.shinycount.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monachrom.shinycount.main.data.Counter
import com.monachrom.shinycount.main.data.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterListViewModel(
    private val counterRepository: CounterRepository
) : ViewModel() {

    init {
        loadCounters()
    }

    private val mutableCounters: MutableLiveData<List<Counter>> = MutableLiveData(emptyList())
    val counters: LiveData<List<Counter>> by lazy { mutableCounters }

    private fun loadCounters() = viewModelScope.launch(Dispatchers.IO) {
        mutableCounters.postValue(counterRepository.findAll())
    }
}