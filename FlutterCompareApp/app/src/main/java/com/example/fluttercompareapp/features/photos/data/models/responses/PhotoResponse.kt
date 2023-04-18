package com.example.fluttercompareapp.features.photos.data.models.responses

data class PhotoResponse(
    val albumId: Int,
    val id: Int,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?
)
