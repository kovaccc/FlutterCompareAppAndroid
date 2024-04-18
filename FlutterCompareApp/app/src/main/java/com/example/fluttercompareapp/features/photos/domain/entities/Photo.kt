package com.example.fluttercompareapp.features.photos.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
@Entity
data class Photo(
    @PrimaryKey val id: Int,
    val title: String?,
    val url: String?
) : Parcelable