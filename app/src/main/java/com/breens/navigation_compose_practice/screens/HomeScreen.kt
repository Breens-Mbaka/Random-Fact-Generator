package com.breens.navigation_compose_practice.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.breens.navigation_compose_practice.ui.theme.NavigationComposePracticeTheme

@Composable
fun HomeScreen(onNavigateToDetailScreen: () -> Unit) {
    NavigationComposePracticeTheme {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { onNavigateToDetailScreen() }) {
                Text(text = "Random Fact", fontSize = 20.sp)
            }
        }
    }
}