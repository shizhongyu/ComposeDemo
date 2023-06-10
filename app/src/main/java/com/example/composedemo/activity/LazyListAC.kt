package com.example.composedemo.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

class LazyListAC : BaseAC() {

    private var itemArray: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        itemArray = resources.getStringArray(R.array.car_array)

        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(itemArray = itemArray as Array<out String>)
                }
            }
        }
    }


    @Composable
    fun MainScreen(itemArray: Array<out String>) {

        val context = LocalContext.current

        val onListItemClick = { text: String ->

            Toast.makeText(
                context, text, Toast.LENGTH_SHORT
            ).show()
        }

        LazyColumn {
            items(itemArray) { model ->
                MyListItem(item = model, onItemClick = onListItemClick)
            }
        }
    }

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun ImageLoader(item: String) {

        val url =
            "https://www.ebookfrenzy.com/book_examples/car_logos/" + item.substringBefore(" ") + "_logo.png"

        Image(
            painter = rememberImagePainter(url),
            contentDescription = "car image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(75.dp)
        )
    }

    @Composable
    fun MyListItem(item: String, onItemClick: (String) -> Unit) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { onItemClick(item) },
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageLoader(item)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        val itemArray: Array<String> = arrayOf(
            "Cadillac Eldorado", "Ford Fairlane", "Plymouth Fury"
        )

        ComposeDemoTheme() {
            MainScreen(itemArray = itemArray)
        }
    }
}