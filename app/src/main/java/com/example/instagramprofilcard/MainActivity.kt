package com.example.instagramprofilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.example.instagramprofilcard.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        enableEdgeToEdge()
        setContent {

            val model = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(model.value) { model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowButtonClickListener = { viewModel.changeFollowingStatus(model) }
                    )
                }
            }
        }
    }

}
