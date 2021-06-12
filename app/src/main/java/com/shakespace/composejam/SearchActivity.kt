package com.shakespace.composejam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.shakespace.composejam.ui.SearchBar
import com.shakespace.composejam.ui.theme.ComposejamTheme

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val keyword = intent.getStringExtra("keyword") ?: ""
        val keyword = intent.getBundleExtra("bundle")?.getString("keyword") ?: ""
        setContent {
            ComposejamTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SearchBar(keyword) {
                        finish()
                    }
                }
            }
        }
    }
}