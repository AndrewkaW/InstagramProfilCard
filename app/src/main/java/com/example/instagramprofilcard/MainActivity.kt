package com.example.instagramprofilcard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.instagramprofilcard.ui.theme.InstagramProfileCard
import com.example.instagramprofilcard.ui.theme.InstagramProfileCardTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            InstagramProfileCardTheme {
                val model = viewModel.models.observeAsState(listOf())
                LazyColumn {
                    items(items = model.value, key = { it.id }) { model ->

                        val dismissBoxState = rememberSwipeToDismissBoxState(
                            confirmValueChange = { value ->
                                val isDismissed = value in setOf(
                                    SwipeToDismissBoxValue.StartToEnd,
                                    SwipeToDismissBoxValue.EndToStart
                                )
                                if (isDismissed) {
                                    viewModel.delete(model)
                                }
                                return@rememberSwipeToDismissBoxState isDismissed
                            }

                        )


                        SwipeToDismissBox(
                            state = dismissBoxState,
                            enableDismissFromStartToEnd = false,
                            enableDismissFromEndToStart = true,
                            backgroundContent = {
                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxSize()
                                        .background(
                                            color = Color.Red.copy(alpha = 0.5f)
                                        ),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Text(
                                        modifier = Modifier.padding(16.dp),
                                        text = "Delete Item",
                                        color = Color.White,
                                        fontSize = 24.sp
                                    )
                                }
                            }
                        ) {
                            InstagramProfileCard(
                                model = model,
                                onFollowButtonClickListener = {
                                    viewModel.changeFollowingStatus(
                                        model
                                    )
                                }
                            )
                        }

                    }
                }
            }
        }
    }

}
