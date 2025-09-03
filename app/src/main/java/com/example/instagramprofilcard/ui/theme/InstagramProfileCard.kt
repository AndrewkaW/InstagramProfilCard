package com.example.instagramprofilcard.ui.theme

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofilcard.InstagramModel
import com.example.instagramprofilcard.R


@Composable
fun InstagramProfileCard(
    model: InstagramModel,
    onFollowButtonClickListener: (InstagramModel) -> Unit
) {

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onBackground
        ),
        elevation = CardDefaults.cardElevation(disabledElevation = 0.dp)
    ) {
        Log.i("Recomposition", "Card")

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                        .size(60.dp),
                    painter = painterResource(R.drawable.ic_instagram),
                    contentDescription = "profile icon",
                    contentScale = ContentScale.Crop
                )
                UserStatistics(title = "Posts", value = "6950")
                UserStatistics(title = "Followers", value = "436M")
                UserStatistics(title = "Following", value = "76")
            }

            Text(
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp,
                text = "Instagram ${model.id}"
            )
            Text(
                text = "#${model.title}",
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp
            )
            Text(
                text = "www.facebook.com/emotional_health",
                fontSize = 14.sp
            )

            FollowButton(model.isFollowed) {
                onFollowButtonClickListener(model)
            }

        }
    }

}


@Composable
private fun UserStatistics(title: String, value: String) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp
        )

        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline,
        )

    }

}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Log.i("Recomposition", "Button")
    Button(
        onClick = {
            clickListener()
        },
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 18.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                Color.Blue.copy(alpha = 0.5f)
            } else {
                Color.Blue
            },
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        val text = if (isFollowed) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(
            fontSize = 14.sp,
            text = text
        )
    }
}
