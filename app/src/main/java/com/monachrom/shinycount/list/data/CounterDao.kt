package com.monachrom.shinycount.list.data

import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query

@Entity
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