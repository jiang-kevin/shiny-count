package com.monachrom.shinycount.list.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monachrom.shinycount.main.data.Counter
import com.monachrom.shinycount.main.data.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewCounterViewModel(
    private val counterRepository: CounterRepository
) : ViewModel() {

    fun createNewCounter(name: String, pokemon: String, method: String) = viewModelScope.launch(Dispatchers.IO) {
        val counter = Counter(0, name, pokemon, method, 0)
        counterRepository.insert(counter)
    }

}
