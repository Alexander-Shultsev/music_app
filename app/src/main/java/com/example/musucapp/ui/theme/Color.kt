package com.example.musucapp.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Purple200 = Color(0xFF1B1436)
val Orange200 = Color(0xFF9F494C)

val Purple80 = Color(0xCC1B1436)
val Orange80 = Color(0xCC9F494C)

val white80 = Color(0xCCFFFFFF)
val white0 = Color(0xFFFFFF)
val white15 = Color(0x26FFFFFF)
val white50 = Color(0x26FFFFFF)

val mainBackground = Brush.linearGradient(
    colors = listOf(
        Purple200,
        Orange200
    ),
    start = Offset(0f, 0f),
    end = Offset(1500f, 1500f),
)

val bottomPlayerBackground = Brush.verticalGradient(
    colors = listOf(
        Purple80,
        Orange80
    )
)