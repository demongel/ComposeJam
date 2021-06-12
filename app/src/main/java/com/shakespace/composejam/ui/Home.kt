package com.shakespace.composejam.ui

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.isFocused
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shakespace.composejam.R
import com.shakespace.composejam.SearchActivity
import com.shakespace.composejam.global.showToast
import com.shakespace.composejam.global.start
import com.shakespace.composejam.ui.theme.ComposejamTheme
import com.shakespace.composejam.viewmodel.MainViewModel

@Composable
fun HomeSearchBar() {
    val viewModel: MainViewModel = viewModel()
    Row {
        val text by viewModel.keyword.observeAsState()
//        var text by remember { mutableStateOf("Compose") }
//        viewModel.findKeyWord()
        val context = LocalContext.current
        Row(
            Modifier
                .padding(12.dp, 4.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .border(
                    BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
                    RoundedCornerShape(16.dp)
                )
                .background(Color.White)
                .padding(12.dp, 4.dp)
                .weight(1f)
                .align(Alignment.CenterVertically),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        context.showToast("Scan QR")
                    },
                painter = painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24),
                contentDescription = "",
                tint = MaterialTheme.colors.primarySurface
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp, 0.dp, 4.dp, 0.dp)
                    .clickable {
                        context.start(SearchActivity::class.java, Bundle().apply {
                            putString("keyword", text ?: "")
                        })
                    },
                text = text ?: "",
                maxLines = 1
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        context.showToast("Open Camera")
                    },
                painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24),
                contentDescription = "",
                tint = MaterialTheme.colors.primarySurface
            )
        }

    }

}


@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun HomePreview() {
    ComposejamTheme {
        HomeSearchBar()
    }
}