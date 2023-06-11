package com.example.composedemo.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebookfrenzy.inapppurchase.PurchaseHelper
import com.example.composedemo.ui.theme.ComposeDemoTheme


class InAppPurchaseAC:BaseAC() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val purchaseHelper = PurchaseHelper(this)
                    purchaseHelper.billingSetup()
                    MainScreen(purchaseHelper)
                }
            }
        }
    }
}

@Composable
fun MainScreen(purchaseHelper: PurchaseHelper) {

    val buyEnabled by purchaseHelper.buyEnabled.collectAsState(false)
    val consumeEnabled by purchaseHelper.consumeEnabled.collectAsState(false)
    val productName by purchaseHelper.productName.collectAsState("")
    val statusText by purchaseHelper.statusText.collectAsState("")

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            productName,
            Modifier.padding(20.dp),
            fontSize = 30.sp)

        Text(statusText)

        Row(Modifier.padding(20.dp)) {

            Button(
                onClick = { purchaseHelper.makePurchase() },
                Modifier.padding(20.dp),
                enabled = buyEnabled
            ) {
                Text("Purchase")
            }

            Button(
                onClick = { purchaseHelper.consumePurchase() },
                Modifier.padding(20.dp),
                enabled = consumeEnabled
            ) {
                Text("Consume")
            }
        }
    }
}
