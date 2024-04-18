package com.example.fluttercompareapp.features.auth.register.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fluttercompareapp.core.domain.util.Resource
import com.example.fluttercompareapp.features.auth.login.ui.states.AuthUiState
import com.example.fluttercompareapp.features.auth.register.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    var uiState by mutableStateOf(AuthUiState())
        private set

    fun onEmailChanged(email: String) {
        uiState = uiState.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        uiState = uiState.copy(password = password)
    }

    fun register() {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                error = null
            )

            when (val result =
                repository.register(email = uiState.email, password = uiState.password)) {
                is Resource.Error -> {
                    uiState = uiState.copy(
                        success = false,
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    uiState = uiState.copy(
                        success = true,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }
}