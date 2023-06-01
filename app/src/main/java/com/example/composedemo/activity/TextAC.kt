package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme


/**
 * Compose 中的文字
 * https://developer.android.com/jetpack/compose/text?hl=zh-cn
 */
class TextAC : BaseAC() {
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
            SimpleText()

        }
    }

    @Composable
    fun SimpleText() {
        Text("Hello World")

        StringResourceText()

        BigText()

        /**
         * 斜体
         */
        ItalicText()

        /**
         * 居中对齐
         */
        CenterText()
    }

    @Composable
    fun StringResourceText() {
        Text(stringResource(R.string.app_name))
    }

    @Composable
    fun BigText() {
        Text("Hello World", fontSize = 30.sp)
    }

    @Composable
    fun ItalicText() {
        Text("Hello World", fontStyle = FontStyle.Italic)
    }

    @Preview(showBackground = true)
    @Composable
    fun CenterText() {
        Text("Hello World", textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp))
    }
}