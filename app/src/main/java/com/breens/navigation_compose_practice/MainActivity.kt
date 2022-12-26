package com.breens.navigation_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.breens.navigation_compose_practice.screens.DetailScreen
import com.breens.navigation_compose_practice.screens.HomeScreen
import com.breens.navigation_compose_practice.ui.theme.NavigationComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposePracticeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {

                    composable(route = "home") {
                        val randomFact = generateRandomFact()
                        HomeScreen(
                            onNavigateToDetailScreen = {
                                navController.navigate(
                                    route = "detail/${randomFact}"
                                )
                            }
                        )
                    }
                    composable(
                        route = "detail/{info}",
                        arguments = listOf(navArgument("info") { type = NavType.StringType })
                    ) { navBackStackEntry ->
                        DetailScreen(
                            onNavigateToHomeScreen = {
                                navController.navigate(route = "home") {
                                    popUpTo(route = "detail/{info}") { inclusive = true }
                                }
                            },
                            navBackStackEntry.arguments?.getString("info")
                        )
                    }
                }
            }
        }
    }
}