package com.example.pc_06_07_leonardolopes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pc_06_07_leonardolopes.ui.screens.BookSearchScreen
import com.example.pc_06_07_leonardolopes.ui.theme.PC_06_07_LeonardoLopesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PC_06_07_LeonardoLopesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookSearchScreen()
                }
            }
        }
    }
}