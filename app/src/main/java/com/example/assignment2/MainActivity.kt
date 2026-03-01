package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background // For adding background color
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.shape.CircleShape // making img shape in circle
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Assignment2()
                }
            }
        }
    }
}

data class AnimeImg(
    val imageRes: Int,
    val title: String,
    val character: String
)

@Composable fun Assignment2(modifier: Modifier = Modifier){

    val AnimeImg = listOf(
        AnimeImg(R.drawable.luffy, "One Piece","Luffy"),
        AnimeImg(R.drawable.naruto,"Naruto Shuppiden","Naruto"),
        AnimeImg(R.drawable.wp11402474,"Demon Slayer","Tanjiro")
    )
    var currentIndex by remember { mutableStateOf(0) }
    val currentAnimeImg =AnimeImg[currentIndex]

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource (id = currentAnimeImg.imageRes),
            contentDescription = currentAnimeImg.title,
            modifier = modifier
                .fillMaxWidth()
                .height(600.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(18.dp))

        Text(
            text = currentAnimeImg.title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )

        Spacer(modifier = modifier.height(10.dp))


        Text(
            text = currentAnimeImg.character,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            // For previous Button
            Button(onClick = {
                if (currentIndex == 0) {
                    currentIndex = AnimeImg.size - 1
                } else {
                    currentIndex = currentIndex - 1
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ))
            {
                Text("Previous",
                    fontWeight = FontWeight.Bold
                )
            }

            // For Next Button
            Button(onClick = {
                if (currentIndex == AnimeImg.size - 1) {
                    currentIndex = 0
                } else {
                    currentIndex = currentIndex + 1
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )) {
                Text("Next",
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}