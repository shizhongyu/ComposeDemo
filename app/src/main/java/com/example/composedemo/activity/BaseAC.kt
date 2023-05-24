package com.example.composedemo.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat

open class BaseAC : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // 设置沉浸式状态栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}