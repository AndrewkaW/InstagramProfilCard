package com.example.instagramprofilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModelProvider
import com.example.instagramprofilcard.ui.theme.InstagramProfileCard
import com.example.instagramprofilcard.ui.theme.InstagramProfileCardTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            InstagramProfileCardTheme {
                val model = viewModel.models.observeAsState(listOf())
                val lazyListState = rememberLazyListState()
                val scope = rememberCoroutineScope()
                LazyColumn(
                    state = lazyListState
                ) {
                    items(model.value) { model ->
                        InstagramProfileCard(
                            model = model,
                            onFollowButtonClickListener = { viewModel.changeFollowingStatus(model) }
                        )
                    }
                }
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            lazyListState.scrollToItem(0)
                        }
                    }
                ) { }
            }
        }
    }

}
