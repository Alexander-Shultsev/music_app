package com.example.musucapp.ui.base

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.musucapp.ui.theme.Typography
import com.example.musucapp.ui.theme.ubuntu
import com.example.musucapp.ui.theme.white80

@Composable
fun H1 (
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        text = title,
        modifier = modifier,
        style = Typography.h1,
        color = color,
    )
}

@Composable
fun ButtonText (title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        style = Typography.h1,
    )
}

@Composable
fun H2 (
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontFamily = ubuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        color = color,
    )
}

@Composable
fun H4 (
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontFamily = ubuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ),
        color = color,
    )
}

@Composable
fun H5 (
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontFamily = ubuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        color = color,
    )
}

@Composable
fun H3 (
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontFamily = ubuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        color = color
    )
}