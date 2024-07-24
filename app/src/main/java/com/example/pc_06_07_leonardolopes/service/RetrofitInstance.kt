package com.example.pc_06_07_leonardolopes.service

import com.example.pc_06_07_leonardolopes.data.BookResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookResponse
}

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://openlibrary.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: BookService by lazy {
        retrofit.create(BookService::class.java)
    }
}
