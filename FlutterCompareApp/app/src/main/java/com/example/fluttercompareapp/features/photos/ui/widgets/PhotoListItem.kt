package com.example.fluttercompareapp.features.photos.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.fluttercompareapp.features.photos.domain.entities.Photo


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoListItem(photo: Photo, onPhotoClick: (String) -> Unit) {
    Surface(
        modifier = Modifier.clickable { onPhotoClick(photo.url ?: "") }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = photo.url,
                contentDescription = photo.title,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = photo.title ?: "",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f)
            )
        }
    }
}