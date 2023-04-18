package com.example.fluttercompareapp.features.photos.data.mappers

import com.example.fluttercompareapp.common.data.mappers.EntityMapper
import com.example.fluttercompareapp.features.photos.data.models.persistence.DBPhoto
import com.example.fluttercompareapp.features.photos.domain.entities.Photo

val photoEntityMapper: EntityMapper<Photo, DBPhoto> = { response ->
    Photo(
        response.id,
        response.title,
        response.url,
    )
}