package com.cxq.mymobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun MyPage() {
    Box {
        Text(text = "Hello World!")
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
        modifier = modifier,
        color = color
    ) {}
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
        Greeting("Android")
    }
}