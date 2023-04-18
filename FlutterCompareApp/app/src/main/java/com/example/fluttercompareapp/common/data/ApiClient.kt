package com.example.fluttercompareapp.common.data

import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import retrofit2.http.GET

interface ApiClient {
    @GET("/photos")
    suspend fun getPhotos(): List<PhotoResponse>
}