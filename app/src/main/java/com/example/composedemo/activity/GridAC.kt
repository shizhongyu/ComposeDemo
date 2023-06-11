package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import kotlin.random.Random

data class BoxProperties(
    val color: Color, val width: Dp
)


class GridAC : BaseAC() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun MainScreen() {

        val items = (1..50).map {
            BoxProperties(
                width = Random.nextInt(50, 200).dp, color = Color(
                    Random.nextInt(255), Random.nextInt(255), Random.nextInt(255), 255
                )
            )
        }

        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            horizontalItemSpacing = 8.dp,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { values ->
                GridItem(properties = values)
            }
        }
    }

    @Composable
    fun GridItem(properties: BoxProperties) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .width(properties.width)
                .clip(RoundedCornerShape(10.dp))
                .background(properties.color)
        )
    }

    @Preview(
        showBackground = true, device = "spec:parent=pixel_5,orientation=landscape"
    )
    @Composable
    fun GreetingPreview() {
        ComposeDemoTheme() {
            MainScreen()
        }
    }
}