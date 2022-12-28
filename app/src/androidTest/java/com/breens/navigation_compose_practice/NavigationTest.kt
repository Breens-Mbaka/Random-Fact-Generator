package com.breens.navigation_compose_practice

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RandomFactGeneratorNavHost(navHostController = navController)
        }
    }

    @Test
    fun verify_StartDestinationIsHomeScreen() {
        composeTestRule
            .onNodeWithText("Random Fact")
            .assertIsDisplayed()
    }

    @Test
    fun performClick_OnRandomFactButton_navigatesToDetailScreen() {
        composeTestRule.onNodeWithText("Random Fact")
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "detail/{info}")
    }
}