package com.example.musucapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musucapp.ui.navigation.NavHostMain
import com.example.musucapp.ui.screen.sign_in.SignInScreen
import com.example.musucapp.ui.theme.MusucAppTheme

lateinit var context: Context
lateinit var activity: Activity
lateinit var lifecycleOwner: LifecycleOwner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = applicationContext
        activity = this
        lifecycleOwner = this

        setContent {
            NavHostMain()
        }
    }
}