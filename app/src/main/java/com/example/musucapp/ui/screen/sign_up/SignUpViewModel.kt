package com.example.musucapp.ui.screen.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

}