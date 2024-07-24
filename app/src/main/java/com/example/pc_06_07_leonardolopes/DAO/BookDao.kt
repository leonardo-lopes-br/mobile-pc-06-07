package com.example.pc_06_07_leonardolopes.DAO

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.pc_06_07_leonardolopes.data.BookCache

@Dao
interface BookDao {
    @Query("SELECT * FROM book_cache WHERE query = :query")
    suspend fun getCachedResult(query: String): BookCache?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(bookCache: BookCache)
}

@Database(entities = [BookCache::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
