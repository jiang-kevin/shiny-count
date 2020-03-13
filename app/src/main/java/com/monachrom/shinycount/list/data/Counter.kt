package com.monachrom.shinycount.list.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Counter(
    @PrimaryKey val id: Int,
    val name: String,
    val pokemon: String,
    val method: String,
    @ColumnInfo(name = "start_date") val startDate: Long,
    val count: Int
)