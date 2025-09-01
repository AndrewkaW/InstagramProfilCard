package com.example.instagramprofilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            LazyColumn {
                item {
                    Text(
                        text = "Title",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 30.sp
                    )
                }
                items(20) {
                    Test(viewModel)
                }
                item {
                    Image(
                        painter = painterResource(R.drawable.ic_instagram),
                        contentDescription = null
                    )
                }

                items(200) {
                    Test(viewModel)
                }
            }
        }
    }

    @Composable
    private fun Test(viewModel: MainViewModel) {
        InstagramProfileCardTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                InstagramProfileCard(viewModel = viewModel)
            }
        }
    }

}
