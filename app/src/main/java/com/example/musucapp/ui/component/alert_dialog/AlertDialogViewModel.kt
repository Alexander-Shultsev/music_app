package com.example.musucapp.ui.component

import android.security.keystore.StrongBoxUnavailableException
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class AlertDialogViewModel: ViewModel() {

    private val _message: MutableLiveData<String> = MutableLiveData()
    val message: LiveData<String> = _message

    fun closeDialog() {
        _message.postValue("")
    }

    fun showDialog(value: String) {
        _message.postValue(value)
    }
}

val alertDialogViewModel: AlertDialogViewModel = AlertDialogViewModel()