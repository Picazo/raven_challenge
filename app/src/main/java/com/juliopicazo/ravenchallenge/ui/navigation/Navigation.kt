package com.juliopicazo.ravenchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.juliopicazo.ravenchallenge.ui.screen.news.NewsScreen
import com.juliopicazo.ravenchallenge.ui.screen.news.model.NewUi
import com.juliopicazo.ravenchallenge.ui.screen.detail.DetailNewScreen
import java.net.URLDecoder

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.NewsScreen.route,
        modifier = modifier,
    ) {

        composable(NavigationScreen.NewsScreen.route) {
            NewsScreen(
                onNewClick = { new ->
                    navController.navigate(NavigationScreen.DetailNewScreen.createRoute(new))
                }
            )
        }

        composable(
            route = NavigationScreen.DetailNewScreen.route,
            arguments = listOf(
                navArgument("new") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val newJson = backStackEntry.arguments?.getString("new") ?: return@composable
            val decodedJson = URLDecoder.decode(newJson, "UTF-8")
            val new = Gson().fromJson(decodedJson, NewUi::class.java)

            DetailNewScreen(
                new = new,
                onBackPressed = { navController.navigateUp() }
            )
        }


    }
}