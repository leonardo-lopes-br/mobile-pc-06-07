package com.example.pc_06_07_leonardolopes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc_06_07_leonardolopes.viewmodel.BookViewModel

@Composable
fun BookSearchScreen(viewModel: BookViewModel = viewModel()) {
    var query by remember { mutableStateOf("") }
    val books by viewModel.books.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.searchBooks(query.trim()) }) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(books) { book ->
                Text(text = book.title, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookSearchScreen()
}
