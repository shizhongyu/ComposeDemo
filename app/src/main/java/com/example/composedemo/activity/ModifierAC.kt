package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composedemo.ui.theme.ComposeDemoTheme


/**
 * 参考：https://developer.android.com/jetpack/compose/modifiers?hl=zh-cn#built-in-modifiers
 */
class ModifierAC : BaseAC() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
//         A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyScrollView()
                }
            }
        }
    }

    @Composable
    private fun Greeting(name: String) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .background(Color.Blue)
        ) {
            Text(text = "Hello,", color = Color.White)
            Text(text = name, color = Color.White)
        }
    }

    @Preview
    @Composable
    fun MyScrollView() {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Greeting(name = "world")
            Greeting02(name = "颐和园")
            ArtistCard()
            ArtistCard02()
        }
    }

    @Composable
    private fun Greeting02(name: String) {
        Row(modifier = Modifier
            .padding(24.dp)
            .background(Color.Blue)
            .fillMaxWidth()
        ) {
            Text(text = "故宫,", color = Color.White)
            Text(text = name, color = Color.White)
        }
    }

    @Composable
    fun ArtistCard(/*...*/) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(width = 200.dp, height = 100.dp)
                .background(Color.Blue)

        ) {
            Text(text = "尺寸大小", color = Color.White)
        }
    }

    @Composable
    fun ArtistCard02(/*...*/) {
        Row(
            modifier = Modifier.size(width = 400.dp, height = 100.dp)
        ) {
            AsyncImage(
                model = "https://www.baidu.com/img/bdlogo.png",
                contentDescription = null,
            )
        }
    }

}