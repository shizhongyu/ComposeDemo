package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.flowdemo.ShareFlowViewModel

class FlowAC : BaseAC() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ScreenSetup()
                }
            }
        }
    }


    @Composable
    fun ScreenSetup(viewModel: ShareFlowViewModel = viewModel()) {
        MainScreen(viewModel)
    }

    @Composable
    fun MainScreen(viewModel: ShareFlowViewModel) {

        // val count by viewModel.stateFlow.collectAsState()
        val count by viewModel.sharedFlow.collectAsState(initial = 0)


        /*
        var count by remember { mutableStateOf<String>("")}

        LaunchedEffect(Unit) {

            val flow1 = (1..5).asFlow()
                .onEach { delay(1000) }
            val flow2 = flowOf("one", "two", "three", "four")
                .onEach { delay(1500) }
            flow1.combine(flow2) { value, string -> "$value, $string" }
                .collect { count = it }
        }
    */

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$count", style = TextStyle(fontSize = 40.sp))
            Button(onClick = { viewModel.startSharedFlow() }) {
                Text("Click Me")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeDemoTheme() {
            ScreenSetup(viewModel())
        }
    }
}