package com.lineup.mytwitter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.lineup.mytwitter.components.ProfileSection
import com.lineup.mytwitter.ui.theme.MyTwitterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTwitterTheme {
                ProfileSection()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TwitterPreview() {
    MyTwitterTheme {
            ProfileSection()
    }
}