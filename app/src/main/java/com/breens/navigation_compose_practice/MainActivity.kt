package com.breens.navigation_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.breens.navigation_compose_practice.ui.theme.NavigationComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomFactGeneratorApp()
        }
    }

    @Composable
    private fun RandomFactGeneratorApp() {
        NavigationComposePracticeTheme {
            val navController = rememberNavController()
            RandomFactGeneratorNavHost(navHostController = navController)
        }
    }

}