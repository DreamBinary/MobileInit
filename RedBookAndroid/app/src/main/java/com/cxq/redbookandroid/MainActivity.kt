package com.cxq.redbookandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxq.redbookandroid.ui.theme.RedBookAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            RedBookAndroidTheme {
                MainPage()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage() {
    Scaffold(
        bottomBar = { BottomBar() },
        contentWindowInsets = WindowInsets.safeContent
    ) {
        Home()
    }
}


@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val itemWidth = (LocalContext.current.resources.displayMetrics.widthPixels / 5).dp
        val modifier = Modifier

        TabBtn(onClick = { }, text = "首页")
        TabBtn(onClick = { }, text = "购物", isSelected = true)

        AddBtn()

        TabBtn(onClick = { }, text = "消息")
        TabBtn(onClick = { }, text = "我")


//        Text("首页")
//        Text("购物")
//        Button(onClick = { }) {
//            Icon(Icons.Default.Add, contentDescription = null)
//        }
//        Text("消息")
//        Text("我")
    }
}

@Composable
fun AddBtn() {


    IconButton(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Red),
        colors = IconButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Black
        ),
        onClick = { }) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}


@Composable
fun TabBtn(onClick: () -> Unit, text: String, isSelected: Boolean = false) {
    var isSelected by remember { mutableStateOf(isSelected) }
    TextButton(
        onClick = {
            onClick()
            isSelected = !isSelected
        },
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            text = text,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            fontSize = if (isSelected) 18.sp else 16.sp
        )
    }
}


@Composable
fun Home() {
    Text("Home")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RedBookAndroidTheme {
        BottomBar()
    }
}