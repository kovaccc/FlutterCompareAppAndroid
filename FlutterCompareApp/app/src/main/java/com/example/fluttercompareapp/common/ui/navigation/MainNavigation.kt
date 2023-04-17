package com.example.fluttercompareapp.common.ui.navigation

import PhotosPage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fluttercompareapp.features.auth.login.ui.elements.pages.LoginPage
import com.example.fluttercompareapp.features.auth.login.ui.state.AuthViewModel
import com.example.fluttercompareapp.features.auth.register.ui.elements.pages.RegisterPage
import com.example.fluttercompareapp.features.splash.ui.elements.pages.SplashPage

@Composable
fun MainNavigation(viewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    val state = viewModel.uiState.collectAsState()
    LaunchedEffect(state) {
        if (!state.value)
            navController.navigate(Screen.Login.route)
    }
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashPage(navController = navController) }
        composable(Screen.Login.route) {
            LoginPage(onRegisterClicked = {
                navController.navigate(
                    Screen.Registration.route
                )
            }, navController = navController)
        }

        composable(Screen.Registration.route) {
            RegisterPage(onLoginClicked = {
                navController.navigate(
                    Screen.Login.route
                )
            }, navController = navController)
        }
        composable(Screen.Photos.route) {
            PhotosPage(navController = navController)
        }
    }
}