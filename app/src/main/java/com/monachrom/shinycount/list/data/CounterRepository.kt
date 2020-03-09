package com.monachrom.shinycount.list.data

import androidx.lifecycle.LiveData

class CounterRepository(private val counterDao: CounterDao) {

    fun findAll(): List<Counter> {
        return counterDao.getAll()
    }

    fun insert(counter: Counter) {
        counterDao.insertAll(counter)
    }
}