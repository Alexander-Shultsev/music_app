package com.example.musucapp.ui.screen.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.ui.base.ButtonMain
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.base.H3
import com.example.musucapp.ui.base.TextFieldMain
import com.example.musucapp.ui.component.SimpleAlertDialog
import com.example.musucapp.ui.theme.MusucAppTheme
import com.example.musucapp.ui.theme.mainBackground

@Composable
fun SignInScreen(viewModel: SignInViewModel = viewModel()) {
    val error = viewModel.error.observeAsState("")

    MusucAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = mainBackground),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Иконка
                H1(title = "Sign in", modifier = Modifier.padding(bottom = 40.dp))

                // поля ввода
                TextFieldMain(
                    label = "Login",
                    onTextChange = { viewModel.changeLoginTextField(it) },
                    keyboardType = KeyboardType.Number
                )
                TextFieldMain(
                    label = "Password",
                    onTextChange = { viewModel.changePasswordTextField(it) },
                    keyboardType = KeyboardType.Number
                )
                // кнопка
                ButtonMain(
                    text = "Login",
                    onClick = { viewModel.signIn() },
                    modifier = Modifier.padding(top = 40.dp)
                )

                H3(
                    title = "I don't have account yet",
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .clickable { }
                )
            }
        }

        when(error.value) {
            "No such user" ->
                SimpleAlertDialog(
                    title = "OH",
                    subtitle = "Incorrect login or password",
                    closeDialog = { viewModel.setNullError() }
                )
            "Empty field" ->
                SimpleAlertDialog(
                    title = "OH",
                    subtitle = "Write all field",
                    closeDialog = { viewModel.setNullError() }
                )
            "success" ->
                SimpleAlertDialog(
                    title = "YES",
                    subtitle = "Success",
                    closeDialog = { viewModel.setNullError() }
                )
            else -> {}
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}