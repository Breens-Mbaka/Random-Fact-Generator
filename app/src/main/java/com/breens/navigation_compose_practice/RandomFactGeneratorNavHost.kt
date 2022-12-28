package com.breens.navigation_compose_practice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.breens.navigation_compose_practice.screens.DetailScreen
import com.breens.navigation_compose_practice.screens.HomeScreen

@Composable
fun RandomFactGeneratorNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {

        composable(route = "home") {
            val randomFact = generateRandomFact()
            HomeScreen(
                onNavigateToDetailScreen = {
                    navHostController.navigate(
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
                    navHostController.navigate(route = "home") {
                        popUpTo(route = "detail/{info}") { inclusive = true }
                    }
                },
                navBackStackEntry.arguments?.getString("info")
            )
        }
    }
}