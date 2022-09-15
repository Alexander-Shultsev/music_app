package com.example.musucapp.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musucapp.ui.screen.sign_in.SignInScreen
import com.example.musucapp.ui.theme.Shapes
import com.example.musucapp.ui.theme.white100

@Composable
fun TextFieldMain() {
    val text = rememberSaveable { mutableStateOf("") }

    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = Modifier
            .background(white100)
            .border(BorderStroke(2.dp, Color.White)),
        shape =

    )
}

@Preview
@Composable
fun TextFieldMainP() {
    TextFieldMain()
}
