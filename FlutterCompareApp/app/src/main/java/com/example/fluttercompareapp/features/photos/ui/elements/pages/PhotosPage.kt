import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun PhotosPage(
    navController: NavController,
) {

    Scaffold(
        topBar = {
            "hi ${FirebaseAuth.getInstance().currentUser?.email}"
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(text = "matej")
//            LazyColumn(
//                modifier = Modifier.weight(1f)
//            ) {
//                items(
//                    items = state.notes,
//                    key = { it.id!! }
//                ) { note ->
//                    NoteItem(
//                        note = note,
//                        backgroundColor = Color(note.colorHex),
//                        onNoteClick = {
//                            navController.navigate("note_detail/${note.id}")
//                        },
//                        onDeleteClick = {
//                            viewModel.deleteNoteById(note.id!!)
//                        },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                            .animateItemPlacement()
//                    )
//                }
//            }
        }
    }
}