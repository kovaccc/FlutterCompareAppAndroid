package com.example.fluttercompareapp.features.photos.domain.repositories

import com.example.fluttercompareapp.core.domain.util.Resource
import com.example.fluttercompareapp.features.photos.domain.entities.Photo

interface PhotosRepository {
    suspend fun refreshPhotos(): Resource<List<Photo>>
}