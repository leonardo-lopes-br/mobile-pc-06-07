package com.example.pc_06_07_leonardolopes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_cache")
data class BookCache(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val query: String,
    val result: String
)
