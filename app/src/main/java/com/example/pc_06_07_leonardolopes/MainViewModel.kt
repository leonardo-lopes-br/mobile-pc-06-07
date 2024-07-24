package com.example.pc_06_07_leonardolopes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.pc_06_07_leonardolopes.DAO.BookDatabase
import com.example.pc_06_07_leonardolopes.data.Book
import com.example.pc_06_07_leonardolopes.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val bookDao = Room.databaseBuilder(
        application,
        BookDatabase::class.java,
        "book_database"
    ).build().bookDao()

    private val repository = BookRepository(bookDao)

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun searchBooks(query: String) {
        val trimmedQuery = query.trim()
        viewModelScope.launch {
            _books.value = repository.searchBooks(trimmedQuery)
        }
    }
}
