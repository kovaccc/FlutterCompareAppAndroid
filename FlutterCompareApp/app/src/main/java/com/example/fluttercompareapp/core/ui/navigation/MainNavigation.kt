package com.example.fluttercompareapp.core.ui.navigation

import PhotosPage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fluttercompareapp.core.ui.constants.ArgConstants
import com.example.fluttercompareapp.features.auth.login.ui.pages.LoginPage
import com.example.fluttercompareapp.features.auth.login.ui.viewmodels.AuthViewModel
import com.example.fluttercompareapp.features.auth.register.ui.pages.RegisterPage
import com.example.fluttercompareapp.features.map.ui.pages.MapPage
import com.example.fluttercompareapp.features.photo_details.ui.pages.PhotoDetailsPage
import com.example.fluttercompareapp.features.photos.domain.entities.Photo
import com.example.fluttercompareapp.features.splash.ui.pages.SplashPage

@Composable
fun MainNavigation(viewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    val state = viewModel.uiState
    LaunchedEffect(state) {
        if (!state)
            navController.navigate(
                Screen.Login.route, navOptions = NavOptions.Builder()
                    .setPopUpTo(navController.graph.startDestinationRoute, inclusive = true)
                    .build()
            )
        else
            navController.navigate(
                Screen.Photos.route, navOptions = NavOptions.Builder()
                    .setPopUpTo(navController.graph.startDestinationRoute, inclusive = true)
                    .build()
            )
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
        composable(Screen.Map.route) {
            MapPage()
        }
        composable(Screen.Photos.route) {
            PhotosPage(
                onMapsClicked = {
                    navController.navigate(Screen.Map.route)
                },
                onPhotoClicked = {

                    navController.currentBackStackEntry?.arguments?.putParcelable(
                        ArgConstants.ARGUMENT_PHOTO,
                        it
                    )
                    navController.navigate(
                        Screen.PhotoDetails.route
                    )
                }
            )
        }
        composable(
            Screen.PhotoDetails.route
        ) {
            PhotoDetailsPage(
                navController.previousBackStackEntry
                    ?.arguments?.getParcelable(ArgConstants.ARGUMENT_PHOTO) ?: Photo(
                    id = -1,
                    title = "",
                    url = ""
                )
            )
        }
    }
}