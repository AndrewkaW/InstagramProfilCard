package com.example.instagramprofilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.instagramprofilcard.ui.theme.InstagramProfileCardTheme
import com.example.instagramprofilcard.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            InstagramProfileCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    InstagramProfileCard(viewModel)
                }
            }
        }
    }

}
