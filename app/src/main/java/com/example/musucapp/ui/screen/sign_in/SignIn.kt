package com.example.musucapp.ui.screen.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musucapp.Greeting
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.theme.MusucAppTheme
import com.example.musucapp.ui.theme.Orange200
import com.example.musucapp.ui.theme.Purple200
import com.example.musucapp.ui.theme.mainBackground

@Composable
fun SignInScreen() {
    MusucAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = mainBackground),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    H1("SignIn")

                }
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}