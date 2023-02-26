package ru.mvlikhachev.myapplication1122.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.mvlikhachev.myapplication1122.presentation.screen.main.MainScreen

sealed class Screens(val rout: String) {
    object MainScreenType: Screens(rout = "main_screen")
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreenType.rout
    ) {

        composable(route = Screens.MainScreenType.rout) {
            MainScreen(navController = navController)
        }
//        composable(route = Screens.DetailsScreenType.rout + "/{id}", arguments = listOf(navArgument("id") {type = NavType.StringType})) {
////            Screens.DetailsScreen(navController = navController, it.arguments?.getString("id"))
//        }
    }
}