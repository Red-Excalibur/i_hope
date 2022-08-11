package com.project001

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.project001.ui.mainScreen.ShowMain
import com.project001.ui.theme.Project001Theme
import dagger.hilt.android.AndroidEntryPoint
var contextt:Context?=null
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contextt=this

        setContent {
            Project001Theme {
                androidx.compose.material.Surface(
                    modifier = Modifier.background(Color.Black)
                ) {
                    ShowMain()
                }

            }
        }
    }
}

