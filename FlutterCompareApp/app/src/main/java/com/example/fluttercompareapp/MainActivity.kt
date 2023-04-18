package com.example.fluttercompareapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fluttercompareapp.common.ui.navigation.MainNavigation
import com.example.fluttercompareapp.common.ui.theme.FlutterCompareAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlutterCompareAppTheme {
                MainNavigation()
            }
        }
    }
}
