package com.monachrom.shinycount.main.data

class CounterRepository(private val counterDao: CounterDao) {

    fun findAll(): List<Counter> {
        return counterDao.getAll()
    }

    fun insert(counter: Counter) {
        counterDao.insertAll(counter)
    }
}