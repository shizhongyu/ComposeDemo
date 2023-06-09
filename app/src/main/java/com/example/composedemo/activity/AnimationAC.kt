package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.favbutton.PreviewButton
import com.example.composedemo.ui.theme.ComposeDemoTheme

class AnimationAC :BaseAC() {


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
//            AnimatableSample()

            AnimateXAsStateDemo()

            PreviewButton()
        }
    }

    @Preview
    @Composable
    fun AnimateXAsStateDemo() {
        var change by remember { mutableStateOf(false) }
        var flag by remember { mutableStateOf(false) }

        val buttonSize by animateDpAsState(
            targetValue = if (change) 32.dp else 24.dp
        )
        if (buttonSize == 32.dp) {
            change = false
        }
        IconButton(
            onClick = {
                change = true
                flag = !flag
            }
        ) {
            Icon(
                Icons.Rounded.Favorite,
                contentDescription = "Icon Button",
                modifier = Modifier.size(buttonSize),
                tint = if (flag) Color.Red else Color.Gray
            )
        }
    }

    @Composable
    private fun AnimatableSample() {
        var isAnimated by remember { mutableStateOf(false) }

        val color = remember { Animatable(Color.DarkGray) }

        // animate to green/red based on `button click`
        LaunchedEffect(isAnimated) {
            color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(color.value)
        )
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Animate Color")
        }
    }
}