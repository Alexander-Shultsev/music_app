package com.example.musucapp.ui.base

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconMain(
    img: Int,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                painter = painterResource(id = img),
                contentDescription = null,
                tint = Color.White,
                modifier = modifier
                    .size(30.dp)
            )
        }
    )
}
