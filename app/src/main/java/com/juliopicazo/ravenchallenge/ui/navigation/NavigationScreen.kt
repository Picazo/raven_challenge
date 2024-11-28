package com.juliopicazo.ravenchallenge.ui.navigation

import com.google.gson.Gson
import com.juliopicazo.ravenchallenge.ui.screen.news.model.NewUi
import java.net.URLEncoder


sealed class NavigationScreen(
    val route: String,
    val baseRoute: String,
) {
    object NewsScreen : NavigationScreen(
        route = "news_screen",
        baseRoute = "news_screen",
    )

    object DetailNewScreen : NavigationScreen(
        route = "detail_new_screen/{new}",
        baseRoute = "detail_new_screen",
    ) {
        fun createRoute(new: NewUi): String {
            val newJson = Gson().toJson(new)
            val encodedJson = URLEncoder.encode(newJson, "UTF-8")
            return "detail_new_screen/$encodedJson"
        }
    }

}
