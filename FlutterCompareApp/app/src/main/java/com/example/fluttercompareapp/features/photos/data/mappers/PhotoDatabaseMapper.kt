package com.example.fluttercompareapp.features.photos.data.mappers

import com.example.fluttercompareapp.common.data.mappers.DatabaseMapper
import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import com.example.fluttercompareapp.features.photos.data.models.persistence.DBPhoto

val photoDatabaseMapper: DatabaseMapper<DBPhoto, PhotoResponse> = { response ->
    DBPhoto(
        response.id,
        response.title,
        response.url,
    )
}