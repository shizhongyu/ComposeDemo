package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class RowColAC : BaseAC() {

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
        Row {
            TextCell("1", Modifier.weight(weight = 0.2f, fill = true))
            TextCell("2", Modifier.weight(weight = 0.4f, fill = true))
            TextCell("3", Modifier.weight(weight = 0.3f, fill = true))
        }
    }

    @Composable
    fun TextCell(text: String, modifier: Modifier = Modifier) {

        val cellModifier = Modifier
            .padding(4.dp)
            .size(100.dp, 100.dp)
            .border(width = 4.dp, color = Color.Black)

        Text(
            text = text,
            cellModifier.then(modifier),
            fontSize = 70.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
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