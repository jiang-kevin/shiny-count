package com.monachrom.shinycount.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monachrom.shinycount.main.data.Counter
import com.monachrom.shinycount.main.data.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterDetailViewModel(
    private val counterRepository: CounterRepository,
    private val counterID: Int
) : ViewModel() {

    private val mutableCounter: MutableLiveData<Counter> = MutableLiveData()
    val counter: LiveData<Counter> by lazy { mutableCounter }

    init {
        loadCounter()
    }

    private fun loadCounter() = viewModelScope.launch(Dispatchers.IO) {
        mutableCounter.postValue(counterRepository.findByID(counterID))
    }
}
