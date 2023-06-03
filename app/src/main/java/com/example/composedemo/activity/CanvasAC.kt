package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class CanvasAC : BaseAC() {

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
            DrawBehind()
//            Box01()

            DrawFuwa()
        }
    }

    @Composable
    fun Box01() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "hello world")
            Text(text = "Compose ")
        }
    }

    @Composable
    fun DrawBehind() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                shape = RoundedCornerShape(8.dp)
                ,modifier = Modifier
                    .size(100.dp)
                    .drawBehind {
                        drawCircle(
                            Color(0xffe7614e),
                            18.dp.toPx() / 2,
                            center = Offset(drawContext.size.width, 0f)
                        )
                    }
            ) {
                Image(painter = painterResource(id = R.drawable.gugong), contentDescription = "Diana")
            }
        }
    }

    @Preview
    @Composable
    fun DrawFuwa() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            var transition = rememberInfiniteTransition()
            val alpha by transition.animateFloat(initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing), repeatMode = RepeatMode.Reverse)
            )
            var context = LocalContext.current
            Box(
                modifier = Modifier
                    .size(340.dp, 300.dp)
                    .onGloballyPositioned { }
                    .drawWithCache {
                        val beibeiImage =
                            ImageBitmap.imageResource(context.resources, R.drawable.gugong)
                        val jingjingImage =
                            ImageBitmap.imageResource(context.resources, R.drawable.gugong)
                        val huanhuanImage =
                            ImageBitmap.imageResource(context.resources, R.drawable.gugong)
                        val yingyingImage =
                            ImageBitmap.imageResource(context.resources, R.drawable.gugong)
                        val niniImage =
                            ImageBitmap.imageResource(context.resources, R.drawable.gugong)
                        onDrawBehind {
                            drawImage(
                                image = beibeiImage,
                                dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                                dstOffset = IntOffset.Zero,
                                alpha = alpha
                            )
                            drawImage(
                                image = jingjingImage,
                                dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                                dstOffset = IntOffset(120.dp.roundToPx(), 0),
                                alpha = alpha
                            )
                            drawImage(
                                image = huanhuanImage,
                                dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                                dstOffset = IntOffset(240.dp.roundToPx(), 0),
                                alpha = alpha
                            )
                            drawImage(
                                image = yingyingImage,
                                dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                                dstOffset = IntOffset(60.dp.roundToPx(), 120.dp.roundToPx()),
                                alpha = alpha
                            )
                            drawImage(
                                image = niniImage,
                                dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                                dstOffset = IntOffset(180.dp.roundToPx(), 120.dp.roundToPx()),
                                alpha = alpha
                            )
                        }
                    }
            )
        }
    }
}