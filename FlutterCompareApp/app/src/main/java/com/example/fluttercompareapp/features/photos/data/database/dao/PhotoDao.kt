package com.example.fluttercompareapp.features.photos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fluttercompareapp.features.photos.data.models.persistence.DBPhoto

@Dao
interface PhotoDao {
    @Query("SELECT * FROM DBPhoto")
    suspend fun getAll(): List<DBPhoto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(DBPhoto: DBPhoto): Long
}