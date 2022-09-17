package com.example.musucapp.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.musucapp.ui.theme.Orange200
import com.example.musucapp.ui.theme.Purple200
import com.example.musucapp.ui.theme.Shapes

@Composable
fun ButtonMain(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        shape = Shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Purple200,
            backgroundColor = Color.White
        ),
        onClick = { onClick() }
    ) {
        ButtonText(text)
    }
}

@Composable
fun ButtonLittle(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    background: Color = Color.Black,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            backgroundColor = background
        ),
        onClick = { onClick() }
    ) {
        ButtonText(text)
    }
}