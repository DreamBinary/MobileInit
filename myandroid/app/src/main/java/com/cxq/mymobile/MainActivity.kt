package com.cxq.mymobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cxq.mymobile.ui.theme.MymobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MymobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyPage()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPage() {
    // TODO
    var cnt = 0
//    var cnt by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF2196F3)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.width(15.dp))
                Text(
                    text = "Android Demo",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    cnt++
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                )
            }
        },
    ) {
        MyWidget(cnt = cnt)
    }
}

@Composable
fun MyWidget(cnt: Int) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            ColorBlock(Modifier.width(50.dp))
            ColorBlock(Modifier.width(50.dp))
        }

        Column {
            ColorBlock(Modifier.height(50.dp))
            ColorBlock(Modifier.height(50.dp))
        }
        Text(
            text = "$cnt",
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
                .padding(5.dp)
        )
    }
}


@Composable
fun ColorBlock(modifier: Modifier = Modifier) {
    // random color
    val colors = listOf(
        Color.Red,
        Color.Black,
        Color.Magenta,
        Color.Cyan,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Gray,
        Color.LightGray,
        Color.DarkGray,
    )
    val color = colors.random()
    Surface(
        modifier = modifier.fillMaxSize(),
        color = color
    ) { }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MymobileTheme {
//        Greeting("Android")
        MyPage()
    }
}