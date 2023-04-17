package com.example.fluttercompareapp.features.auth.login.ui.state

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fluttercompareapp.features.auth.register.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    var uiState by mutableStateOf(true)
        private set

    init {
        subscribeToAuthChanges()
    }

    private fun subscribeToAuthChanges() {
        viewModelScope.launch {
            repository.subscribeToAuthChanges().collect {
                uiState = it != null
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            uiState = false
        }
    }

}