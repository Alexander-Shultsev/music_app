package com.example.musucapp.ui.component.alert_dialog

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musucapp.ui.component.AlertDialogViewModel
import com.example.musucapp.ui.component.SimpleAlertDialog
import com.example.musucapp.ui.screen.sign_in.alertDialogViewModel

object AlertItem {
    const val UncorrectLoginData = "UncorrectLoginData"
    const val EmptyField = "EmptyField"
    const val SuccessSignIn = "SuccessSignIn"
    const val SuccessSignUp = "SuccessSignUp"
    const val PasswordNotMatchRepeatPassword = "PasswordNotMatchRepeatPassword"
    const val UpdateSong = "UpdateSong"
    const val AddSong = "AddSong"
    const val AddUpdateSong = "AddUpdateSong"
}

@Composable
fun AlertDialogController() {
    val message = alertDialogViewModel.message.observeAsState()

    Log.i(TAG, "recompose")

    when(message.value) {
        AlertItem.UncorrectLoginData ->
            SimpleAlertDialog(
                title = "Message",
                subtitle = "Incorrect login or password",
            )
        AlertItem.EmptyField ->
            SimpleAlertDialog(
                title = "Message",
                subtitle = "Write all field",
            )
        AlertItem.SuccessSignIn ->
            SimpleAlertDialog(
                title = "Message",
                subtitle = "Success sign in",
            )
        AlertItem.SuccessSignUp ->
            SimpleAlertDialog(
                title = "Message",
                subtitle = "Success sign up",
            )
        AlertItem.PasswordNotMatchRepeatPassword ->
            SimpleAlertDialog(
                title = "Message",
                subtitle = "Password and repeat password don't match",
            )
        AlertItem.UpdateSong -> {}
        AlertItem.AddSong -> {}
        AlertItem.AddUpdateSong -> {}
//            ChangeItemAlertDialog(
//                title = "Message",
//                subtitle = "Password and repeat password don't match",
//            )
        else -> {}
    }
}