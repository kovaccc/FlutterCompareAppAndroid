package com.example.fluttercompareapp.features.photos.data.datasources.remote

import com.example.fluttercompareapp.common.data.ApiClient
import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRemoteDataSource @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getPhotos(): List<PhotoResponse> {
        return apiClient.getPhotos()
    }
}
