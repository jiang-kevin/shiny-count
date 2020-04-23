package com.monachrom.shinycount.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.monachrom.shinycount.main.data.Counter

class CounterDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val counterID: String = savedStateHandle["id"] ?:
            throw kotlin.IllegalArgumentException("Missing counter ID")
}
