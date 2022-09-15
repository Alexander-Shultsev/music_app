package com.example.musucapp.ui.component

import android.icu.text.CaseMap
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.musucapp.ui.base.ButtonLittle
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.base.H3


@Composable
fun SimpleAlertDialog(
    title: String,
    subtitle: String,
    closeDialog: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { closeDialog() },
        title = { H1(title = title, color = Color.Black) },
        text = { H3(title = subtitle, color = Color.Black) },
        confirmButton = {
            ButtonLittle(
                onClick = { closeDialog() },
                text = "oK",
            )
        }
    )
}