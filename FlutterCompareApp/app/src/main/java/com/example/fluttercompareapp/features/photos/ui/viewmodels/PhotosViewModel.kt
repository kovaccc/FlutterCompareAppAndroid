package com.example.fluttercompareapp.features.photos.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fluttercompareapp.core.domain.util.Resource
import com.example.fluttercompareapp.features.photos.domain.repositories.PhotosRepository
import com.example.fluttercompareapp.features.photos.ui.states.PhotosUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val repository: PhotosRepository,
) : ViewModel() {

    var uiState by mutableStateOf(PhotosUiState())
        private set

    fun getPhotos() {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                error = null
            )

            when (val result =
                repository.refreshPhotos()) {
                is Resource.Error -> {
                    uiState = uiState.copy(
                        isLoading = false,
                        error = result.message
                    )
                }

                is Resource.Success -> {
                    uiState = uiState.copy(
                        photos = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
            }

        }
    }

}