package com.example.fluttercompareapp.core.data.clients

import com.example.fluttercompareapp.features.photos.data.datasources.PhotosRemoteDataSource
import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import retrofit2.http.GET

interface ApiClient : PhotosRemoteDataSource {
    @GET("/photos")
    override suspend fun getPhotos(): List<PhotoResponse>
}

