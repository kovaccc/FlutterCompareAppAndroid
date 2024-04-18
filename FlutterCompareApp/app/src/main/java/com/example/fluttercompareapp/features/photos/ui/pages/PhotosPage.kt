import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fluttercompareapp.features.auth.login.ui.viewmodels.AuthViewModel
import com.example.fluttercompareapp.features.photos.domain.entities.Photo
import com.example.fluttercompareapp.features.photos.ui.widgets.PhotoListItem
import com.example.fluttercompareapp.features.photos.ui.viewmodels.PhotosViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun PhotosPage(
    authViewModel: AuthViewModel = hiltViewModel(),
    photosViewModel: PhotosViewModel = hiltViewModel(),
    onPhotoClicked: (photo: Photo) -> Unit,
    onMapsClicked: () -> Unit,
) {

    LaunchedEffect(true) {
        photosViewModel.getPhotos()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "hi ${FirebaseAuth.getInstance().currentUser?.email}") },
                actions = {
                    IconButton(onClick = { authViewModel.logout() }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                    }

                    IconButton(onClick = {
                        onMapsClicked()
                    }) {
                        Icon(Icons.Default.Place, contentDescription = "Map")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (photosViewModel.uiState.isLoading)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            else
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(
                        items = photosViewModel.uiState.photos,
                        key = { it.id }
                    ) { photo ->
                        PhotoListItem(photo = photo, onPhotoClick = {
                            onPhotoClicked(photo)
                        })
                    }
                }
        }
    }
}