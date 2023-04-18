package com.example.fluttercompareapp.features.photos.data.repositories

import com.example.fluttercompareapp.common.constants.Constants
import com.example.fluttercompareapp.common.domain.Resource
import com.example.fluttercompareapp.features.photos.data.datasources.local.PhotosLocalDataSource
import com.example.fluttercompareapp.features.photos.data.datasources.remote.PhotosRemoteDataSource
import com.example.fluttercompareapp.features.photos.data.mappers.photoEntityMapper
import com.example.fluttercompareapp.features.photos.domain.entities.Photo
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.ktx.performance
import javax.inject.Inject

interface PhotosRepository {
    suspend fun refreshPhotos(): Resource<List<Photo>>
}

class PhotosRepositoryImpl @Inject constructor(
    private val photosRemoteDataSource: PhotosRemoteDataSource,
    private val photosLocalDataSource: PhotosLocalDataSource
) : PhotosRepository {
    override suspend fun refreshPhotos(): Resource<List<Photo>> {

        return try {
            val getPhotosNetworkTrace =
                Firebase.performance.newTrace(Constants.PHOTOS_NETWORK_PERF_TRACE)
            getPhotosNetworkTrace.start()
            val photosResponses = photosRemoteDataSource.getPhotos()
            getPhotosNetworkTrace.stop()

            val savePhotosTrace =
                Firebase.performance.newTrace(Constants.PHOTOS_SAVE_LOCAL_PERF_TRACE)
            savePhotosTrace.start()
            photosResponses.forEach {
                photosLocalDataSource.insertPhoto(it)
            }
            savePhotosTrace.stop()

            val getPhotosTrace =
                Firebase.performance.newTrace(Constants.PHOTOS_GET_LOCAL_PERF_TRACE)
            getPhotosTrace.start()
            val localPhotos = photosLocalDataSource.getPhotos()
            getPhotosTrace.stop()
            
            val domainPhotos = localPhotos.map {
                photoEntityMapper(it)
            }
            Resource.Success(
                domainPhotos
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }

}