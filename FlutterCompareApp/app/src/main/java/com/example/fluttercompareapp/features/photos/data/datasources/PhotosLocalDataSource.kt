package com.example.fluttercompareapp.features.photos.data.datasources

import com.example.fluttercompareapp.features.photos.data.dao.PhotoDao
import com.example.fluttercompareapp.features.photos.domain.entities.Photo
import javax.inject.Inject
import javax.inject.Singleton

interface PhotosLocalDataSource {

    suspend fun insertPhoto(photo: Photo): Long

    suspend fun getPhotos(): List<Photo>
}

@Singleton
class PhotosLocalDataSourceImpl @Inject constructor(private val photoDao: PhotoDao) :
    PhotosLocalDataSource {

    override suspend fun insertPhoto(photo: Photo): Long = photoDao.insert(photo)

    override suspend fun getPhotos(): List<Photo> = photoDao.getAll()

}