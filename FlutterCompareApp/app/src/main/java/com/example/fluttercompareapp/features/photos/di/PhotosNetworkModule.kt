package com.example.fluttercompareapp.features.photos.di

import com.example.fluttercompareapp.core.data.clients.ApiClient
import com.example.fluttercompareapp.features.photos.data.datasources.PhotosRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class PhotosNetworkModule {

    @Binds
    @Singleton
    abstract fun bindPhotosRemoteDataSource(
        apiClient: ApiClient
    ): PhotosRemoteDataSource
}