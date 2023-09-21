package com.example.fluttercompareapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fluttercompareapp.common.ui.navigation.MainNavigation
import com.example.fluttercompareapp.common.ui.theme.FlutterCompareAppTheme
import com.example.fluttercompareapp.common.utils.receivers.AirPlaneModeReceiver
import com.example.fluttercompareapp.common.utils.receivers.TestReceiver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val airPlaneModeReceiver = AirPlaneModeReceiver()
    private val testReceiver = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        println("onCreate")
        super.onCreate(savedInstanceState)
        registerReceiver(airPlaneModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(testReceiver, IntentFilter("TEST_ACTION"))
        setContent {
            FlutterCompareAppTheme {
                MainNavigation()
            }
        }
    }

    // called when activity gets visible
    override fun onStart() {
        println("onStart")
        super.onStart()
    }

    override fun onResume() {
        println("onResume")
        super.onResume()
    }

    // put app in background onPause -> onStop
    // always called so do things here when you are closing activity
    // for example save some important data
    override fun onPause() {
        println("onPause")
        super.onPause()
    }

    // not guaranted by android system that it will be called, same as for onDestroy
    override fun onStop() {
        println("onStop")
        super.onStop()
    }

    override fun onRestart() {
        println("onRestart")
        super.onRestart()
    }

    // configuration changes when inlafting layout again, or finishing activity
    // not guaranted by android system that it will be called, same as for onStop
    override fun onDestroy() {
        println("onDestroy")
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
        unregisterReceiver(testReceiver)
    }

}
