package com.example.fluttercompareapp.features.auth.login.ui.state

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

    private val _uiState = MutableStateFlow(false)
    val uiState: StateFlow<Boolean> = _uiState

    init {
        subscribeToAuthChanges()
    }

    private fun subscribeToAuthChanges() {
        viewModelScope.launch {
            repository.subscribeToAuthChanges().collect {

                _uiState.value = it != null
            }
        }
    }

}