package com.example.musucapp.ui.screen.sign_in

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.musucapp.lifecycleOwner
import com.example.musucapp.model.Post
import com.example.musucapp.model.service
import com.example.musucapp.ui.component.AlertDialogViewModel
import com.example.musucapp.ui.component.alert_dialog.AlertItem
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.NavMenuItems
import com.example.musucapp.ui.navigation.navigateTo
import kotlinx.coroutines.launch
import java.lang.Exception

class SignInViewModel: ViewModel() {

    private val _loginTextField: MutableLiveData<String> = MutableLiveData("")
    private val _passwordTextField: MutableLiveData<String> = MutableLiveData("")
    private val _posts: MutableLiveData<ArrayList<Post>> = MutableLiveData(arrayListOf())
    private var isLogin: Boolean = false

    val loginTextField: LiveData<String> = _loginTextField
    val passwordTextField: LiveData<String> = _passwordTextField
    val posts: LiveData<ArrayList<Post>> = _posts

    fun changeLoginTextField(text: String) {
        _loginTextField.postValue(text)
    }

    fun changePasswordTextField(text: String) {
        _passwordTextField.postValue(text)
    }

    fun signIn() {
        val login = loginTextField.value
        val password = passwordTextField.value

        if (login != "" && password != "") {
            getPosts()

            _posts.observe(lifecycleOwner) { data ->
                run {
                    data.forEach { item ->
                        if (item.userId.toString() == login && item.id.toString() == password) {
                            showDialog(AlertItem.SuccessSignIn)
                            navigateTo(NavMenuItems.MySongs.route)
                            isLogin = true
                            return@observe
                        }
                    }
                    if (!isLogin) {
                        showDialog(AlertItem.UncorrectLoginData)
                        isLogin = false
                    }
                }
            }
        } else {
            showDialog(AlertItem.EmptyField)
        }
    }

    private fun showDialog(value: String) {
        alertDialogViewModel.showDialog(value)
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                _posts.value = service.getAllPost().body()
            } catch (e: Exception) {
                Log.e(TAG, "error: $e")
            }
        }
    }
}