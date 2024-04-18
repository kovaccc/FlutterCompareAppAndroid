package com.example.fluttercompareapp.features.photos.data.mappers

import com.example.fluttercompareapp.core.data.mappers.EntityMapper
import com.example.fluttercompareapp.features.photos.data.models.responses.PhotoResponse
import com.example.fluttercompareapp.features.photos.domain.entities.Photo

val photoEntityMapper: EntityMapper<Photo, PhotoResponse> = { response ->
    Photo(
        response.id,
        response.title,
        response.url,
    )
}