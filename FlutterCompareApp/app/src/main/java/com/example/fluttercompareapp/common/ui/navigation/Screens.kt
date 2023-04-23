package com.example.fluttercompareapp.common.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Registration : Screen("registration")
    object Photos : Screen("photos")
    object PhotoDetails : Screen("photo_details")
    object Map : Screen("map")
}