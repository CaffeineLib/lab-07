package com.example.lab_7
import androidx.navigation.NavController
import androidx.compose.runtime.Composable

class FormulaZeroApp {

    @Composable
    fun FormulaZeroApp() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("races") { UpcomingRacesScreen(navController) }
        }
    }
}