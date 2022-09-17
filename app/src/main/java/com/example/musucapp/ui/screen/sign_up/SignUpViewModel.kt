package com.example.musucapp.ui.screen.sign_in

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musucapp.lifecycleOwner
import com.example.musucapp.model.Post
import com.example.musucapp.model.service
import com.example.musucapp.ui.component.alert_dialog.AlertItem
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.navigateTo
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {

    private val _firstNameTextField: MutableLiveData<String> = MutableLiveData("")
    private val _lastNameTextField: MutableLiveData<String> = MutableLiveData("")
    private val _passwordTextField: MutableLiveData<String> = MutableLiveData("")
    private val _repeatPasswordTextField: MutableLiveData<String> = MutableLiveData("")
    private val _posts: MutableLiveData<Post> = MutableLiveData()

    private val repeatPasswordTextField: LiveData<String> = _repeatPasswordTextField
    private val firstNameTextField: LiveData<String> = _firstNameTextField
    private val lastNameTextField: LiveData<String> = _lastNameTextField
    private val passwordTextField: LiveData<String> = _passwordTextField

    fun changeFirstNameField(text: String) {
        _firstNameTextField.postValue(text)
    }

    fun changeLastNameField(text: String) {
        _lastNameTextField.postValue(text)
    }

    fun changePasswordTextField(text: String) {
        _passwordTextField.postValue(text)
    }

    fun changeRepeatPasswordTextField(text: String) {
        _repeatPasswordTextField.postValue(text)
    }

    private fun showDialog(value: String) {
        alertDialogViewModel.showDialog(value)
    }

    fun signUp() {
        if (firstNameTextField.value!!.isNotEmpty()
            && lastNameTextField.value!!.isNotEmpty()
            && passwordTextField.value!!.isNotEmpty()
            && repeatPasswordTextField.value!!.isNotEmpty()
        ) {
            if (passwordTextField.value == repeatPasswordTextField.value) {
                sendPost()

                _posts.observe(lifecycleOwner) { newValue ->
                    run {
                        if (newValue.body != "") {
                            showDialog(AlertItem.SuccessSignUp)
                            navigateTo(NavItems.SignIn.route)
                        }
                    }
                }
            } else
                showDialog(AlertItem.PasswordNotMatchRepeatPassword)
        } else
            showDialog(AlertItem.EmptyField)
    }

    private fun sendPost() {
        viewModelScope.launch {
            try {
                _posts.postValue(
                    service.sendPost(
                        passwordTextField.value!!.toInt(),
                        repeatPasswordTextField.value!!.toInt(),
                        firstNameTextField.value!!,
                        lastNameTextField.value!!
                    ).body()
                )
            } catch (e: Exception) {
                Log.i(TAG, "signUp1: $e")
            }
        }
    }
}