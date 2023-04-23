package com.example.fluttercompareapp.features.photo_details.ui.elements.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.fluttercompareapp.features.photos.domain.entities.Photo

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoDetailsPage(
    photo: Photo
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            GlideImage(
                model = photo.url,
                contentDescription = photo.title,
                modifier = Modifier
                    .fillMaxSize()
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}