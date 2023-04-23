package com.example.fluttercompareapp.features.photos.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: Int,
    val title: String?,
    val url: String?
) : Parcelable