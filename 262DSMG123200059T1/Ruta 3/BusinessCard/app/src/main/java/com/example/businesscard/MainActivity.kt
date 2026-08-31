package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {

    val backgroundColor = Color(0xFFD6E9D6)
    val androidGreen = Color(0xFF3DDC84)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(
                            id = R.drawable.android_logo
                        ),
                        contentDescription = "Logo de Android",
                        modifier = Modifier.size(90.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Rodrigo Sanchez",
                        fontSize = 24.sp,
                        color = Color.DarkGray
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Android Developer Extraordinaire",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = androidGreen
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ContactItem(
                    icon = Icons.Default.Phone,
                    text = "+51 980 502 337",
                    contentDescription = "Teléfono"
                )

                ContactItem(
                    icon = Icons.Default.Share,
                    text = "@AndroidDev",
                    contentDescription = "Usuario"
                )

                ContactItem(
                    icon = Icons.Default.Email,
                    text = "rodrigo.sanchez@gmail.com",
                    contentDescription = "Correo electrónico"
                )
            }
        }
    }
}

@Composable
fun ContactItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    contentDescription: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(18.dp),
            tint = Color(0xFF3DDC84)
        )

        Spacer(
            modifier = Modifier.size(12.dp)
        )

        Text(
            text = text,
            fontSize = 10.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun BusinessCardTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme {
        content()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {

    BusinessCardTheme {
        BusinessCard()
    }
}