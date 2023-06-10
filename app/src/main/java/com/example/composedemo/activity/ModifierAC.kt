package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composedemo.R
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
            CircleImage()
            DemoScreen()
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

    @Composable
    fun CircleImage() {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Blue)
                .size(200.dp)
        ) {
            AsyncImage(
                model = "https://img1.baidu.com/it/u=3661233036,3166165312&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

    @Composable
    fun DemoScreen() {

        val modifier = Modifier
            .border(width = 2.dp, color = Color.Black)
            .padding(all = 10.dp)

        val secondModifier = Modifier.height(100.dp)

        Column(
            Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Hello Compose",
                modifier.then(secondModifier),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            CustomImage(
                R.drawable.gugong,
                Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp)))
        }
    }

    @Composable
    fun CustomImage(image: Int, modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme() {
            DemoScreen()
        }
    }

}