package com.example.musucapp.ui.screen.my_songs

import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.R
import com.example.musucapp.model.Photo
import com.example.musucapp.ui.base.*
import com.example.musucapp.ui.component.SimpleAlertDialog
import com.example.musucapp.ui.navigation.NavMenuItems
import com.example.musucapp.ui.screen.update_song.UpdateSongAlertDialog
import com.example.musucapp.ui.theme.*

@Composable
fun MySongsScreen(viewModel: MySongsViewModel = viewModel()) {
    val error = viewModel.error.observeAsState("")
    val photos = viewModel.photos.observeAsState(arrayListOf(Photo(0,0,"","")))
    val isOpenUpdateSong = viewModel.isOpenUpdateSong.observeAsState(false)
    val isOpenAddSong = viewModel.isOpenAddSong.observeAsState(false)

    MusucAppTheme {
        Scaffold(
            bottomBar = {
                Column(
                    modifier = Modifier
                        .height(110.dp)
                        .background(white50)
                        .fillMaxWidth()
                ) {

                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = mainBackground),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 30.dp)
                            .fillMaxWidth()
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // menu
                        IconButton(
                            onClick = { /*TODO*/ },
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_row_left),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                        )
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            H1(title = "My Playlist")
                        }
                        // more
                        IconButton(
                            onClick = { /* вызвать контекстне меню */ },
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        )
                    }
                }

                // Список
                item {
                    for (item in 1..20) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(white15)
                                .pointerInput(Unit) {
                                    detectTapGestures (
                                        onDoubleTap = { viewModel.changeVisibleUpdateSongAlertDialog() },
                                        onLongPress = { viewModel.changeVisibleAddSongAlertDialog() }
                                    )
                                }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(15.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(shape = RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                // Заголовок и подзаголовок
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 15.dp)
                                ) {
                                    H2(
                                        title = "Matias Bagato",
                                        modifier = Modifier.padding(bottom = 3.dp)
                                    )
                                    H4(title = "Untitled C", color = white50)
                                }
                                // Пролоджительность
                                H5(title = "3:14")
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

    if (isOpenAddSong.value) {

    }

    if (isOpenUpdateSong.value) {
        UpdateSongAlertDialog(
            photo = Photo(1, 1, "Love", "Klava Koka"),
            closeDialog = { viewModel.changeVisibleUpdateSongAlertDialog() }
        )
    }

    when (error.value) {
        "No such user" ->
            SimpleAlertDialog(
                title = "OH",
                subtitle = "Incorrect login or password",
                closeDialog = { viewModel.setNullError() }
            )
        "Empty field" ->
            SimpleAlertDialog(
                title = "OH",
                subtitle = "Write all field",
                closeDialog = { viewModel.setNullError() }
            )
        "success" ->
            SimpleAlertDialog(
                title = "YES",
                subtitle = "Success",
                closeDialog = { viewModel.setNullError() }
            )
        else -> {}
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    MySongsScreen()
}