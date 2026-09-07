package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0F172A)
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableStateOf(1) }

    val imageResource = when (currentArtwork) {
        1 -> R.drawable.gato
        2 -> R.drawable.elangel
        3 -> R.drawable.granola
        else -> R.drawable.gato
    }

    val title = when (currentArtwork) {
        1 -> "Cat"
        2 -> "El Angel Caido"
        3 -> "La gran ola de Kanagawa"
        else -> "-"
    }

    val artist = when (currentArtwork) {
        1 -> "André Duranton"
        2 -> "Alexandre Cabanel"
        3 -> "Katsushika Hokusai"
        else -> "-"
    }

    val year = when (currentArtwork) {
        1 -> "1973"
        2 -> "1847"
        3 -> "1831"
        else -> "-"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFF8FAFC),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    Text(
                        text = artist,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color(0xFF38BDF8)
                    )
                    Text(
                        text = " • $year",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF94A3B8),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        1 -> 3
                        2 -> 1
                        3 -> 2
                        else -> 1
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF334155),
                    contentColor = Color(0xFFF8FAFC)
                )
            ) {
                Text("Anterior", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        1 -> 2
                        2 -> 3
                        3 -> 1
                        else -> 1
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF38BDF8),
                    contentColor = Color(0xFF0F172A)
                )
            ) {
                Text("Siguiente", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}