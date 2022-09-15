package com.example.musucapp.ui.base

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musucapp.ui.theme.Typography

@Composable
fun H1 (title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        style = Typography.h1
    )
}