package com.example.fluttercompareapp.features.splash.ui.elements.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fluttercompareapp.R
import com.example.fluttercompareapp.common.ui.navigation.Screen
import com.example.fluttercompareapp.features.auth.login.ui.state.AuthViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashPage(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        delay(2000)
        if (!state.value)
            navController.navigate(Screen.Registration.route)
        else
            navController.navigate(Screen.Photos.route)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
    }
}