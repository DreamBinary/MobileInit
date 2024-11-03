package com.cxq.redbookandroid

/**
 * @author CXQ
 * @date 2024/11/3
 */
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HomeViewModel : ViewModel() {
    //    val text = mutableStateOf("Welcome to Home Page")
    var scrollState: ScrollState = ScrollState(0)
}


@Composable
fun HomePage(viewModel: HomeViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val items = List(100) { "Item $it" }
        val columns = 2
        val columnItems = List(columns) { mutableListOf<String>() }

        items.forEachIndexed { index, item ->
            columnItems[index % columns].add(item)
        }

        Row(
            modifier = Modifier.verticalScroll(viewModel.scrollState)
        ) {
            columnItems.forEach { column ->
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    column.forEach { item ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth()
                                .height(Random.nextInt(100, 300).dp) // 随机高度
                                .background(Color.Gray)
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}



