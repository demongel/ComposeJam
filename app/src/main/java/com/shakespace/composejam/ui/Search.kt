package com.shakespace.composejam.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.*
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
import com.shakespace.composejam.R
import com.shakespace.composejam.global.showToast
import com.shakespace.composejam.ui.theme.ComposejamTheme


@Composable
fun SearchBar(keyword: String, onBackPressed: () -> Unit) {
    Row() {
        var text by remember { mutableStateOf(keyword) }
        val context = LocalContext.current
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable {
                    onBackPressed()
                }
                .padding(8.dp, 0.dp, 0.dp, 0.dp),
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            contentDescription = "",
            tint = MaterialTheme.colors.primarySurface
        )
        Row(
            Modifier
                .padding(4.dp)
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
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp, 0.dp, 4.dp, 0.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                cursorBrush = SolidColor(LocalContentColor.current),
                singleLine = true,
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            context.showToast("Open Camera")
                        }
                    },
                painter = painterResource(
                    id = if (text.isNotEmpty()) {
                        R.drawable.ic_close
                    } else {
                        R.drawable.ic_baseline_photo_camera_24
                    }
                ),
                contentDescription = "",
                tint = MaterialTheme.colors.primarySurface.copy(alpha = (if (text.isNotEmpty()) 0.5f else 1.0f))
            )
        }
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable {
                    context.showToast("Start Searching $text")
                }
                .padding(0.dp, 0.dp, 8.dp, 0.dp),
            painter = painterResource(id = R.drawable.ic_baseline_search_24),
            contentDescription = "Start Searching",
            tint = MaterialTheme.colors.primarySurface
        )

    }

}


@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun SearchPreview() {
    ComposejamTheme {
//        SearchBar { println("back") }
    }
}