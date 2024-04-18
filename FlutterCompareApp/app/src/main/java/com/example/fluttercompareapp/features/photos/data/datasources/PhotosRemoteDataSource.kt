package com.example.fluttercompareapp.features.photos.data.datasources

import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface PhotosRemoteDataSource {
    suspend fun getPhotos(): List<PhotoResponse>
}
