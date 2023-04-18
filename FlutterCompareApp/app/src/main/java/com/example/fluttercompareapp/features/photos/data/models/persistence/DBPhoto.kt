package com.example.fluttercompareapp.features.photos.data.models.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBPhoto(
    @PrimaryKey val id: Int,
    val title: String?,
    val url: String?
)