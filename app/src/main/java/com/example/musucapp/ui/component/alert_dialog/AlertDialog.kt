package com.example.musucapp.ui.component

import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.ui.base.ButtonLittle
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.base.H3
import com.example.musucapp.ui.screen.sign_in.alertDialogViewModel
import com.example.musucapp.ui.theme.Orange200
import com.example.musucapp.ui.theme.Purple200


@Composable
fun SimpleAlertDialog(
    title: String,
    subtitle: String,
) {
    AlertDialog(
        onDismissRequest = { alertDialogViewModel.closeDialog() },
        title = { H1(title = title, color = Color.Black) },
        text = { H3(title = subtitle, color = Color.Black) },
        confirmButton = {
            ButtonLittle(
                onClick = { alertDialogViewModel.closeDialog() },
                text = "oK",
            )
        }
    )
}