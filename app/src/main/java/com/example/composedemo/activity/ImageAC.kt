package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme


/**
 * https://developer.android.com/jetpack/compose/graphics/images/customize?hl=zh-cn
 * https://developer.android.com/jetpack/compose/graphics/draw/modifiers?hl=zh-cn
 */
class ImageAC  : BaseAC() {
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
            Image01()
        }
    }

    @Preview
    @Composable
    fun Image01() {
        Column() {
            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(10.dp))


            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(10.dp))

            val borderWidth = 4.dp
            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.aspectRatio(16f / 9f).width(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))


//            Image(
//                painter = painterResource(id = R.mipmap.gugong),
//                contentDescription = stringResource(id = R.string.app_name),
//                colorFilter = ColorFilter.tint(Color.Yellow)
//            )

            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = stringResource(id = R.string.app_name),
                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0.1f) })
            )

            Spacer(modifier = Modifier.height(10.dp))


            Image(
                painter = painterResource(id = R.mipmap.gugong),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .blur(
                        radiusX = 10.dp,
                        radiusY = 10.dp,
                        edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.gugong),
                contentDescription = "Sunset",
                modifier = Modifier
                    .graphicsLayer {
                        this.scaleX = 1.2f
                        this.scaleY = 0.8f
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.gugong),
                contentDescription = "Sunset",
                modifier = Modifier
                    .graphicsLayer {
                        this.translationX = 100.dp.toPx()
                        this.translationY = 10.dp.toPx()
                    }
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .graphicsLayer {
                            clip = true
                            shape = CircleShape
                        }
                        .background(Color(0xFFF06292))
                ) {
                    Text(
                        "Hello Compose",
                        style = TextStyle(color = Color.Black, fontSize = 46.sp),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4DB6AC))
                )
            }
        }
    }
}