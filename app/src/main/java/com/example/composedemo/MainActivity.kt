package com.example.composedemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.activity.AnimateStateAC
import com.example.composedemo.activity.AnimateVisibilityAC
import com.example.composedemo.activity.AnimationAC
import com.example.composedemo.activity.BaseAC
import com.example.composedemo.activity.BoxLayoutAC
import com.example.composedemo.activity.CanvasAC
import com.example.composedemo.activity.ConstraintlayoutAC
import com.example.composedemo.activity.ImageAC
import com.example.composedemo.activity.LazyListAC
import com.example.composedemo.activity.LazyListSticky
import com.example.composedemo.activity.ListAC
import com.example.composedemo.activity.ModifierAC
import com.example.composedemo.activity.RowColAC
import com.example.composedemo.activity.SlideAC
import com.example.composedemo.activity.StateAC
import com.example.composedemo.activity.StringAC
import com.example.composedemo.activity.TextAC
import com.example.composedemo.data.ActivityItem
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : BaseAC() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LazyListDemo()
                }
            }
        }
    }
}

@Composable
fun LazyListDemo() {
    var listItems = mutableListOf<ActivityItem>()
    listItems.add(ActivityItem(ModifierAC::class.simpleName.toString(), ModifierAC::class.java))
    listItems.add(ActivityItem(ImageAC::class.simpleName.toString(), ImageAC::class.java))
    listItems.add(ActivityItem(TextAC::class.simpleName.toString(), TextAC::class.java))
    listItems.add(ActivityItem(StateAC::class.simpleName.toString(), StateAC::class.java))
    listItems.add(ActivityItem(CanvasAC::class.simpleName.toString(), CanvasAC::class.java))
    listItems.add(ActivityItem(AnimationAC::class.simpleName.toString(), AnimationAC::class.java))
    listItems.add(ActivityItem(SlideAC::class.simpleName.toString(), SlideAC::class.java))
    listItems.add(ActivityItem(ConstraintlayoutAC::class.simpleName.toString(), ConstraintlayoutAC::class.java))
    listItems.add(ActivityItem(ListAC::class.simpleName.toString(), ListAC::class.java))
    listItems.add(ActivityItem(BoxLayoutAC::class.simpleName.toString(), BoxLayoutAC::class.java))
    listItems.add(ActivityItem(AnimateVisibilityAC::class.simpleName.toString(), AnimateVisibilityAC::class.java))
    listItems.add(ActivityItem(AnimateStateAC::class.simpleName.toString(), AnimateStateAC::class.java))
    listItems.add(ActivityItem(StringAC::class.simpleName.toString(), StringAC::class.java))
    listItems.add(ActivityItem(LazyListAC::class.simpleName.toString(), LazyListAC::class.java))
    listItems.add(ActivityItem(LazyListSticky::class.simpleName.toString(), LazyListSticky::class.java))
    listItems.add(ActivityItem(RowColAC::class.simpleName.toString(), RowColAC::class.java))



    listItems.reverse()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(listItems.size) { index ->
            val item = listItems.get(index)
            MyListItem(description = item.name, item.className)
        }
    }
}

@Composable
fun MyListItem(description: String, clazz: Class<*>) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Blue)
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                val intent = Intent(context, clazz)
                context.startActivity(intent)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = description, fontSize = 16.sp, textAlign = TextAlign.Center, color = Color.White
        )
    }
}

