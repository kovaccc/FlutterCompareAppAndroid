package com.example.fluttercompareapp.features.photos.data.repositories

import com.example.fluttercompareapp.core.domain.util.Resource
import com.example.fluttercompareapp.features.photos.data.constants.PerformanceTraceConstants
import com.example.fluttercompareapp.features.photos.data.datasources.PhotosLocalDataSourceImpl
import com.example.fluttercompareapp.features.photos.data.datasources.PhotosRemoteDataSource
import com.example.fluttercompareapp.features.photos.data.mappers.photoEntityMapper
import com.example.fluttercompareapp.features.photos.domain.entities.Photo
import com.example.fluttercompareapp.features.photos.domain.repositories.PhotosRepository
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.ktx.performance
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photosRemoteDataSource: PhotosRemoteDataSource,
    private val photosLocalDataSource: PhotosLocalDataSourceImpl
) : PhotosRepository {
    override suspend fun refreshPhotos(): Resource<List<Photo>> {

        return try {
            val getPhotosNetworkTrace =
                Firebase.performance.newTrace(PerformanceTraceConstants.PHOTOS_NETWORK_PERF_TRACE)
            getPhotosNetworkTrace.start()
            val photosResponses = photosRemoteDataSource.getPhotos()
            getPhotosNetworkTrace.stop()

            val savePhotosTrace =
                Firebase.performance.newTrace(PerformanceTraceConstants.PHOTOS_SAVE_LOCAL_PERF_TRACE)
            savePhotosTrace.start()
            photosResponses.forEach {
                photosLocalDataSource.insertPhoto(photoEntityMapper(it))
            }
            savePhotosTrace.stop()

            val getPhotosTrace =
                Firebase.performance.newTrace(PerformanceTraceConstants.PHOTOS_GET_LOCAL_PERF_TRACE)
            getPhotosTrace.start()
            val localPhotos = photosLocalDataSource.getPhotos()
            getPhotosTrace.stop()
            Resource.Success(
                localPhotos
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }

}