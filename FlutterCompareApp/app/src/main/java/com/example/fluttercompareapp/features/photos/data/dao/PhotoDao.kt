package com.example.fluttercompareapp.features.photos.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fluttercompareapp.features.photos.domain.entities.Photo

@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo")
    suspend fun getAll(): List<Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo): Long
}