package com.example.fluttercompareapp.features.auth.login.ui.elements.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fluttercompareapp.R
import com.example.fluttercompareapp.common.ui.navigation.Screen
import com.example.fluttercompareapp.features.auth.login.ui.state.LoginViewModel

@Composable
fun LoginPage(
    onRegisterClicked: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {

    LaunchedEffect(viewModel.uiState) {
//        if (viewModel.uiState.success)
//            navController.navigate(Screen.Photos.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = viewModel.uiState.email,
            onValueChange = {
                viewModel.onEmailChanged(
                    it
                )
            },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = viewModel.uiState.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        if (viewModel.uiState.isLoading)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        else
            Button(
                onClick = {
                    viewModel.login()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.log_in))
            }

        Button(
            onClick = {
                viewModel.onEmailChanged(email = "matejkovacevic91@gmail.com")
                viewModel.onPasswordChanged(password = "matej123$")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("test login")
        }

        Text(
            stringResource(R.string.do_not_have_account_sign_up),
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clickable { onRegisterClicked.invoke() }
        )
    }
}