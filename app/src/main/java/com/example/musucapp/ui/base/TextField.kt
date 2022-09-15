package com.example.musucapp.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musucapp.ui.screen.sign_in.SignInScreen
import com.example.musucapp.ui.theme.Shapes
import com.example.musucapp.ui.theme.white80

@Composable
fun TextFieldMain(
    label: String,
    onTextChange: (text: String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val text = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
            onTextChange(text.value)
        },
        shape = Shapes.large,
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.White,
            textColor = Color.White,
            unfocusedLabelColor = white80,
            focusedLabelColor = Color.White,
            cursorColor = Color.White
        ),
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

//@Preview
//@Composable
//fun TextFieldMainP() {
//    TextFieldMain()
//}
