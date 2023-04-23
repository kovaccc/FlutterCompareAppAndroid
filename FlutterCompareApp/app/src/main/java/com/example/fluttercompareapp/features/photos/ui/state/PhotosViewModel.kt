package com.example.fluttercompareapp.features.photos.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fluttercompareapp.common.domain.Resource
import com.example.fluttercompareapp.features.photos.data.repositories.PhotosRepository
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