package com.example.instagramprofilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagramprofilcard.ui.theme.InstagramProfileCardTheme
import com.example.instagramprofilcard.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramProfileCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    InstagramProfileCard()
                }
            }
        }
    }

    @Preview
    @Composable
    fun ImageTest(){
        Image(
            modifier = Modifier.clip(CircleShape),
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.FillHeight
        )
    }

}
