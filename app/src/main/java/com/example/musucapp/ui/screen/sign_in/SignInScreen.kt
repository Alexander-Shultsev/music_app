package com.example.musucapp.ui.screen.sign_in

import android.content.ContentValues.TAG
import android.util.Log
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
import com.example.musucapp.ui.component.AlertDialogViewModel
import com.example.musucapp.ui.component.SimpleAlertDialog
import com.example.musucapp.ui.component.alert_dialog.AlertDialogController
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.navigateTo
import com.example.musucapp.ui.theme.MusucAppTheme
import com.example.musucapp.ui.theme.mainBackground

var alertDialogViewModel: AlertDialogViewModel = AlertDialogViewModel()

@Composable
fun SignInScreen(viewModel: SignInViewModel = viewModel()) {
    val message = alertDialogViewModel.message.observeAsState()

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
                        .clickable { navigateTo(NavItems.SignUp.route) }
                )
            }
        }
        if (message.value != "") {
            AlertDialogController()
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}