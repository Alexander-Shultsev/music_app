package com.example.musucapp.ui.screen.my_songs

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.musucapp.lifecycleOwner
import com.example.musucapp.model.Post
import com.example.musucapp.model.service
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.NavMenuItems
import kotlinx.coroutines.launch
import java.lang.Exception

class MySongsViewModel: ViewModel() {

    private val _loginTextField: MutableLiveData<String> = MutableLiveData("")
    private val _passwordTextField: MutableLiveData<String> = MutableLiveData("")
    private val _posts: MutableLiveData<ArrayList<Post>> = MutableLiveData(arrayListOf())
    private val _error: MutableLiveData<String> = MutableLiveData("")
    private var isLogin: Boolean = false

    val loginTextField: LiveData<String> = _loginTextField
    val passwordTextField: LiveData<String> = _passwordTextField
    val posts: LiveData<ArrayList<Post>> = _posts
    val error: LiveData<String> = _error

    fun changeLoginTextField(text: String) {
        _loginTextField.postValue(text)
    }

    fun changePasswordTextField(text: String) {
        _passwordTextField.postValue(text)
    }

    fun signIn() {
        val login = loginTextField.value
        val password = passwordTextField.value
        Log.i(TAG, "signIn: $login, $password")

        if (login != "" && password != "") {
            getPosts()

            _posts.observe(lifecycleOwner) { data ->
                run {
                    data.forEach { item ->
                        if (item.userId.toString() == login && item.id.toString() == password) {
//                            navController.navigate(NavMenuItems.MySongs.route)
                            _error.postValue("success")
                            isLogin = true
                            return@observe
                        }
                    }
                    if (!isLogin) {
                        _error.postValue("No such user")
                        isLogin = false
                        Log.i(TAG, "signIn: fail")
                    }
                }
            }
        } else {
            _error.postValue("Empty field")
        }
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

    fun setNullError() {
        _error.postValue("")
    }
}