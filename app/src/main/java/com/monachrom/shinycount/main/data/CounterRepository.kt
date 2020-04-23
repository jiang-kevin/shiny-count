package com.monachrom.shinycount.main.data

class CounterRepository(private val counterDao: CounterDao) {

    fun findAll(): List<Counter> {
        return counterDao.getAll()
    }

    fun findByID(id: Int): Counter {
        return counterDao.findById(id)
    }

    fun insert(counter: Counter) {
        counterDao.insertAll(counter)
    }
}