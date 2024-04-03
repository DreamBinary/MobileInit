package com.cxq.mymobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
//        MyWidget(cnt = cnt)
        MyAnim()
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
fun MyAnim() {
    var anim by remember {
        mutableStateOf(true)
    }
    val time = 1000
    val animatedAlpha by animateFloatAsState(
        targetValue = if (anim) 1.0f else 0.5f,
        animationSpec = tween(durationMillis = time),
        label = "alpha"
    )
    val animatedSize by animateDpAsState(
        targetValue = if (anim) 100.dp else 50.dp,
        label = "size",
        animationSpec = tween(durationMillis = time)
    )

    val animatedDegree by animateFloatAsState(
        targetValue = if (anim) 0f else 360f,
        label = "degree",
        animationSpec = tween(durationMillis = time)
    )

    val animatedCornerShape by animateDpAsState(
        targetValue = if (anim) 0.dp else 50.dp,
        label = "corner",
        animationSpec = tween(durationMillis = time)
    )

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        ColorBlock(
            Modifier
                .size(100.dp)
                .clipToBounds()
                .graphicsLayer {
                    alpha = animatedAlpha
                }
                .rotate(animatedDegree)
                .clip(RoundedCornerShape(animatedCornerShape))
                .clickable {
                    anim = !anim
                }
        )
    }

}

@Composable
fun ColorBlock(modifier: Modifier = Modifier, color: Color? = null) {
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

    Surface(
        modifier = modifier.fillMaxSize(),
        color = color ?: colors.random()
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