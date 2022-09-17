package com.example.musucapp.ui.screen.my_songs

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.R
import com.example.musucapp.ui.base.*
import com.example.musucapp.ui.component.alertDialogViewModel
import com.example.musucapp.ui.component.alert_dialog.AlertDialogController
import com.example.musucapp.ui.screen.edit_song.EditSongAlertDialog
import com.example.musucapp.ui.screen.update_song.UpdateSongAlertDialog
import com.example.musucapp.ui.theme.*

@Composable
fun MySongsScreen(viewModel: MySongsViewModel = viewModel()) {
    val selectedTabNumber = viewModel.selectedTabNumber.observeAsState(0)
    val songs = viewModel.songs.observeAsState()
    val currentSong = viewModel.currentSong.observeAsState(0)

    val message = alertDialogViewModel.message.observeAsState(0)
    val isOpenUpdateSong = viewModel.isOpenUpdateSong.observeAsState(false)
    val isOpenAddSong = viewModel.isOpenAddSong.observeAsState(false)
    val isOpenEditSong = viewModel.isOpenEditSong.observeAsState(false)

    MusucAppTheme {
        Scaffold(
            bottomBar = {
                Column(
                    modifier = Modifier
                        .height(110.dp)
                        .background(bottomPlayerBackground)
                        .fillMaxWidth()
                ) {
                    Divider(
                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth(),
                        color = Color.White
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 30.dp)
                    ) {
                        IconMain(
                            R.drawable.ic_prev_songs,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )
                        IconMain(
                            R.drawable.ic_repeat,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (songs.value != null) {
                                H1(songs.value!![currentSong.value].title.split(" ")[0])
                                H4(songs.value!![currentSong.value].id.toString())
                            }
                        }

                        IconMain(
                            R.drawable.ic_pause,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )
                        IconMain(
                            R.drawable.ic_next_song,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )
                    }
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

                    // TopAppBar
                    item {
                        Row(
                            modifier = Modifier
                                .padding(top = 30.dp)
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
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(30.dp)
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
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                }
                            )
                        }
                    }

                    // TabBar
                    item {
                        TabRow(
                            selectedTabIndex = selectedTabNumber.value,
                            backgroundColor = white0,
                            contentColor = Color.White,
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 15.dp)
                        ) {
                            for (item in 0 until viewModel.nameTabs.size) {
                                Tab(
                                    selected = selectedTabNumber.value == item,
                                    onClick = { viewModel.setTabSelected(item) },
                                    text = { Text(viewModel.nameTabs[item]) }
                                )
                            }
                        }
                    }

                    // Список
                    item {
                        if (songs.value != null) {
                            if (selectedTabNumber.value == 0) {
                                for (item in 0..songs.value!!.size - 4990) {
                                    Box(
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .background(white15)
                                            .pointerInput(Unit) {
                                                detectTapGestures(
                                                    onLongPress = {
                                                        viewModel.changeVisibleEditSongAlertDialog()
                                                        viewModel.setCurrentMusic(item)
                                                    },
                                                    onTap = { viewModel.setCurrentMusic(item) }
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
                                                    title = songs.value!![item].title,
                                                    modifier = Modifier.padding(bottom = 3.dp)
                                                )
                                                H4(
                                                    title = songs.value!![item].id.toString(),
                                                    color = white50
                                                )
                                            }
                                            // Пролоджительность
                                            H5(title = songs.value!![item].albumId.toString())
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(15.dp))
                                }
                            } else {
                                for (item in 10..songs.value!!.size - 4980) {
                                    Box(
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .background(white15)
                                            .clickable { }
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
                                                    title = songs.value!![0].title,
                                                    modifier = Modifier.padding(bottom = 3.dp)
                                                )
                                                H4(
                                                    title = songs.value!![0].id.toString(),
                                                    color = white50
                                                )
                                            }
                                            // Пролоджительность
                                            H5(title = songs.value!![0].albumId.toString())
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(15.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    if (message.value != "") {
        AlertDialogController()
    }

    when {
        isOpenEditSong.value ->
            EditSongAlertDialog(
                checkSong = songs.value?.get(currentSong.value),
                updateElem = { viewModel.changeVisibleUpdateSongAlertDialog() },
                deleteElem = { viewModel.deleteSong(currentSong.value) },
                closeDialog = { viewModel.changeVisibleEditSongAlertDialog() }
            )
        isOpenAddSong.value -> {  }
        isOpenUpdateSong.value -> {
            UpdateSongAlertDialog(
                checkSong = songs.value?.get(currentSong.value),
                closeDialog = { viewModel.changeVisibleUpdateSongAlertDialog() }
            )
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    MySongsScreen()
}