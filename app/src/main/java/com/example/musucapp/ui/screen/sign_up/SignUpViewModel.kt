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
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.navigateTo
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {

    private val _firstNameTextField: MutableLiveData<String> = MutableLiveData()
    val firstNameTextField: LiveData<String> = _firstNameTextField

    fun changeFirstNameField(text: String) {
        _firstNameTextField.postValue(text)
    }


    private val _lastNameTextField: MutableLiveData<String> = MutableLiveData()
    val lastNameTextField: LiveData<String> = _lastNameTextField

    fun changeLastNameField(text: String) {
        _lastNameTextField.postValue(text)
    }


    private val _passwordTextField: MutableLiveData<String> = MutableLiveData()
    val passwordTextField: LiveData<String> = _passwordTextField

    fun changePasswordTextField(text: String) {
        _passwordTextField.postValue(text)
    }


    private val _repeatPasswordTextField: MutableLiveData<String> = MutableLiveData()
    val repeatPasswordTextField: LiveData<String> = _repeatPasswordTextField

    fun changeRepeatPasswordTextField(text: String) {
        _repeatPasswordTextField.postValue(text)
    }

    private val _posts: MutableLiveData<Post> = MutableLiveData()
    private val _error: MutableLiveData<String> = MutableLiveData("")
    val error: LiveData<String> = _error

    fun signUp() {
        if (firstNameTextField.value != ""
            && lastNameTextField.value != ""
            && passwordTextField.value != ""
            && repeatPasswordTextField.value != ""
        ) {
            if (passwordTextField.value == repeatPasswordTextField.value) {
                sendPost()

                _posts.observe(lifecycleOwner) { newValue ->
                    run {
                        if (newValue.body != "") {
                            _error.postValue("success")
                            navigateTo(NavItems.SignIn.route)
                        }
                    }
                }
            } else {
                _error.postValue("Repeat password")
            }
        } else {
            _error.postValue("Empty field")
        }
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
                Log.i(TAG, "signUp: $e")
            }
        }
    }

    fun setNullError() {
        _error.postValue("")
    }
}