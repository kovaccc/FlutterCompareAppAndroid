package com.example.fluttercompareapp.features.photos.ui.states

import com.example.fluttercompareapp.features.photos.domain.entities.Photo

data class PhotosUiState(
    val photos: List<Photo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
