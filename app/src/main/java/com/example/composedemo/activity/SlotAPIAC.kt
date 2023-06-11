package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class SlotAPIAC : BaseAC() {

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


    @Composable
    fun MainScreen() {

        var linearSelected by remember { mutableStateOf(true) }
        var imageSelected by remember { mutableStateOf(true) }

        val onLinearClick = { value: Boolean ->
            linearSelected = value
        }

        val onTitleClick = { value: Boolean ->
            imageSelected = value
        }

        ScreenContent(linearSelected = linearSelected,
            imageSelected = imageSelected,
            onLinearClick = onLinearClick,
            onTitleClick = onTitleClick,
            titleContent = {
                if (imageSelected) {

                    TitleImage(drawing = R.drawable.baseline_cloud_download_24)

                } else {
                    Text(
                        "Downloading",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(30.dp)
                    )
                }
            },
            progressContent = {
                if (linearSelected) {
                    LinearProgressIndicator(Modifier.height(40.dp))
                } else {
                    CircularProgressIndicator(
                        Modifier.size(200.dp), strokeWidth = 18.dp
                    )
                }
            })

    }

    @Composable
    fun ScreenContent(
        linearSelected: Boolean,
        imageSelected: Boolean,
        onTitleClick: (Boolean) -> Unit,
        onLinearClick: (Boolean) -> Unit,
        titleContent: @Composable () -> Unit,
        progressContent: @Composable () -> Unit
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            titleContent()
            progressContent()
            CheckBoxes(linearSelected, imageSelected, onTitleClick, onLinearClick)
        }
    }

    @Composable
    fun CheckBoxes(
        linearSelected: Boolean,
        imageSelected: Boolean,
        onTitleClick: (Boolean) -> Unit,
        onLinearClick: (Boolean) -> Unit
    ) {
        Row(
            Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = imageSelected, onCheckedChange = onTitleClick
            )
            Text("Image Title")
            Spacer(Modifier.width(20.dp))
            Checkbox(
                checked = linearSelected, onCheckedChange = onLinearClick
            )
            Text("Linear Progress")
        }
    }

    @Composable
    fun TitleImage(drawing: Int) {
        Image(
            painter = painterResource(drawing),
            contentDescription = "title image",
            modifier = Modifier.size(150.dp)
        )
    }

    @Preview(showSystemUi = true)
    @Composable
    fun DemoPreview() {
        MainScreen()
    }
}