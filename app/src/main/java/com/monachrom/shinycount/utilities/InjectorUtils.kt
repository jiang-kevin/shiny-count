package com.monachrom.shinycount.utilities

import android.content.Context
import androidx.savedstate.SavedStateRegistryOwner
import com.monachrom.shinycount.detail.CounterDetailViewModelFactory
import com.monachrom.shinycount.list.viewmodels.CounterListViewModelFactory
import com.monachrom.shinycount.list.viewmodels.NewCounterViewModelFactory
import com.monachrom.shinycount.main.data.AppDatabase
import com.monachrom.shinycount.main.data.CounterRepository

object InjectorUtils {

    private fun getCounterRepository(context: Context): CounterRepository {
        return CounterRepository(
            AppDatabase.getDatabase(context.applicationContext).counterDao())
    }

    fun provideNewCounterViewModelFactory(context: Context): NewCounterViewModelFactory {
        val repository = getCounterRepository(context)
        return NewCounterViewModelFactory(repository)
    }

    fun provideCounterListViewModelFactory(context: Context): CounterListViewModelFactory {
        val repository = getCounterRepository(context)
        return CounterListViewModelFactory(repository)
    }

    fun provideCounterDetailViewModelFactory(
        context: Context, counterID: Int
    ): CounterDetailViewModelFactory {
        val repository = getCounterRepository(context)
        return CounterDetailViewModelFactory(repository, counterID)
    }
}