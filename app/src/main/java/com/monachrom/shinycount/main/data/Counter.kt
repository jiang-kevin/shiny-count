package com.monachrom.shinycount.main.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Counter(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val pokemon: String,
    val method: String,
    @ColumnInfo(name = "start_date") val startDate: Long,
    val count: Int = 0
)