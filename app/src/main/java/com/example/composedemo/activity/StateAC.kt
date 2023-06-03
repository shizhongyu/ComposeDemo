package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class StateAC : BaseAC() {

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
            HelloContent()

            CounterComponent()
        }
    }

    @Composable
    fun HelloContent() {
        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text("Name") }
            )
        }
    }

    @Preview
    @Composable
    fun CounterComponent() {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            var counter by remember { mutableStateOf(0) }

            Text( //1
                "Click the buttons to adjust your value:",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text( //2
                "$counter",
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.bodyLarge,
                fontSize = 18.sp
            )

            Row {
                Button(
                    onClick = { counter-- },
                    Modifier.weight(1f)
                ) {
                    Text("-")
                }
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = { counter++ },
                    Modifier.weight(1f)
                ) {
                    Text("+")
                }
            }
        }

    }
}