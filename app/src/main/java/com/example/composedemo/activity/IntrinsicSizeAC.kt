package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class IntrinsicSizeAC : BaseAC() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }


    @Composable
    fun MainScreen() {
        var textState by remember { mutableStateOf("") }

        val onTextChange = { text: String ->
            textState = text
        }

        Column(
            Modifier
                .width(200.dp)
                .padding(5.dp)) {

            Column(Modifier.width(IntrinsicSize.Min)) {
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp),
                    text = textState
                )

                Box(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                        .background(Color.Blue))
            }
            MyTextField(text = textState, onTextChange = onTextChange)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField(text: String, onTextChange: (String) -> Unit) {

        TextField(
            value = text,
            onValueChange = onTextChange
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeDemoTheme() {
            MainScreen()
        }
    }
}