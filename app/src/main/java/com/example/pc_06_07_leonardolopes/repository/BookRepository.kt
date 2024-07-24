package com.example.pc_06_07_leonardolopes.repository

import android.util.Log
import com.example.pc_06_07_leonardolopes.data.BookCache
import com.example.pc_06_07_leonardolopes.DAO.BookDao
import com.example.pc_06_07_leonardolopes.data.Book
import com.example.pc_06_07_leonardolopes.data.BookResponse
import com.example.pc_06_07_leonardolopes.service.RetrofitInstance
import com.google.gson.Gson

class BookRepository(private val bookDao: BookDao) {

    suspend fun searchBooks(query: String): List<Book> {
        val trimmedQuery = query.trim()
        val cachedResult = bookDao.getCachedResult(trimmedQuery)
        return if (cachedResult != null) {
            Log.d("BookRepository", "Retrieved from cache: $trimmedQuery")
            parseResult(cachedResult.result)
        } else {
            Log.d("BookRepository", "Fetching from API: $trimmedQuery")
            val response = RetrofitInstance.api.searchBooks(trimmedQuery)
            val resultJson = Gson().toJson(response)
            bookDao.insertResult(BookCache(query = trimmedQuery, result = resultJson))
            response.docs
        }
    }

    private fun parseResult(json: String): List<Book> {
        val response = Gson().fromJson(json, BookResponse::class.java)
        return response.docs
    }
}
