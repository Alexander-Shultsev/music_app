package com.example.musucapp.ui.screen.edit_song

import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.model.Song
import com.example.musucapp.ui.base.ButtonLittle
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.theme.Orange200
import com.example.musucapp.ui.theme.Purple200

@Composable
fun EditSongAlertDialog(
    checkSong: Song?,
    updateElem: () -> Unit,
    deleteElem: () -> Unit,
    closeDialog: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { closeDialog() },
        title = { H1(title = checkSong?.title!!.split(" ")[0], color = Color.Black) },
        confirmButton = {
            ButtonLittle(
                text = "Delete",
                onClick = {
                    deleteElem()
                    closeDialog()
                },
                background = Purple200
            )
        },
        dismissButton = {
            ButtonLittle(
                text = "Update",
                onClick = {
                    updateElem()
                    closeDialog()
                },
                background = Orange200
            )
        }
    )
}