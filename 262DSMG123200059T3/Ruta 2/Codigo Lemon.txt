package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var requiredSqueezes by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .statusBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lemonade",
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().weight(1f)
        ) {
            when (currentStep) {
                1 -> {
                    Text(
                        text = stringResource(R.string.lemon_select),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        border = BorderStroke(2.dp, Color(0xFF008080)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.lemon_tree_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    currentStep = 2
                                    requiredSqueezes = (2..4).random()
                                    squeezeCount = 0
                                }
                                .padding(16.dp)
                        )
                    }
                }
                2 -> {
                    Text(
                        text = stringResource(R.string.lemon_squeeze),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        border = BorderStroke(2.dp, Color(0xFF008080)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.lemon_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    squeezeCount++
                                    if (squeezeCount >= requiredSqueezes) {
                                        currentStep = 3
                                    }
                                }
                                .padding(16.dp)
                        )
                    }
                }
                3 -> {
                    Text(
                        text = stringResource(R.string.lemon_drink),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        border = BorderStroke(2.dp, Color(0xFF008080)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.glass_of_lemonade_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    currentStep = 4
                                }
                                .padding(16.dp)
                        )
                    }
                }
                4 -> {
                    Text(
                        text = stringResource(R.string.lemon_restart),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        border = BorderStroke(2.dp, Color(0xFF008080)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.empty_glass_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    currentStep = 1
                                }
                                .padding(16.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}