package com.example.fluttercompareapp.features.auth.login.ui.states

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
)
