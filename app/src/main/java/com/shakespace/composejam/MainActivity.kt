package com.shakespace.composejam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.shakespace.composejam.ui.HomeSearchBar
import com.shakespace.composejam.ui.theme.ComposejamTheme
import com.shakespace.composejam.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposejamTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeSearchBar()
                }
            }
        }
        val viewModel by viewModels<MainViewModel>()
        viewModel.findKeyWord()
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun DefaultPreview() {
    ComposejamTheme {
        HomeSearchBar()
    }
}