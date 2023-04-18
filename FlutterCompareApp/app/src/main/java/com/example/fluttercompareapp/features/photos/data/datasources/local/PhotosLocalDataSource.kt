package com.example.fluttercompareapp.features.photos.data.datasources.local

import com.example.fluttercompareapp.features.photos.data.database.dao.PhotoDao
import com.example.fluttercompareapp.features.photos.data.mappers.photoDatabaseMapper
import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import com.example.fluttercompareapp.features.photos.data.models.persistence.DBPhoto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosLocalDataSource @Inject constructor(private val photoDao: PhotoDao) {

    suspend fun insertPhoto(photoResponse: PhotoResponse): Long {
        return photoDao.insert(photoDatabaseMapper(photoResponse))
    }

    suspend fun getPhotos(): List<DBPhoto> {
        return photoDao.getAll()
    }
}