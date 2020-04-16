package com.monachrom.shinycount.main.data

import androidx.room.*

@Dao
interface CounterDao {
    @Query("SELECT * FROM counter")
    fun getAll(): List<Counter>

    @Query("SELECT * FROM counter WHERE id = :id")
    fun findById(id: Int): Counter

    @Insert
    fun insertAll(vararg counters: Counter)

    @Delete
    fun delete(counter: Counter)
}