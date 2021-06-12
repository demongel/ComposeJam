package com.shakespace.composejam

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.shakespace.composejam", appContext.packageName)
    }
}


@Composable
fun baseInput() {
    Row(modifier = Modifier.background(Color.Red)) {
        var text by remember { mutableStateOf("HELLO") }
        Row(
            Modifier
                .padding(4.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .border(BorderStroke(0.5.dp, Color.Red), RoundedCornerShape(12.dp))
                .background(Color.White)
                .height(IntrinsicSize.Min)
                .padding(12.dp, 4.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)

        ) {
            BasicTextField(
                modifier = Modifier
                    .background(Color.Blue)
                    .weight(1f),
                value = text,
                onValueChange = {
                    text = it
                },
                cursorBrush = SolidColor(LocalContentColor.current)
            )
            if (text.isNotEmpty()) {
                IconButton(
                    onClick = { text = "" },
                    modifier = Modifier
                        // 放在padding之前 点击上下区域也有效果
                        .clickable { text = "" }
                        .size(16.dp, 16.dp)
                        .align(Alignment.CenterVertically)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp, 10.dp),
                        imageVector = Icons.Filled.Close,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp),
            imageVector = Icons.Filled.Search,
            contentDescription = ""
        )
    }

}

//textStyle = if (isHint()) {
//    captionTextStyle.copy(color = LocalContentColor.current)
//} else {
//    MaterialTheme.typography.body1.copy(color = LocalContentColor.current)
//}

@Composable
fun normalInput() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(Color.Green)
    ) {
        var text by remember { mutableStateOf("HELLO") }
//            var text by mutableStateOf("")
        TextField(
            modifier = Modifier
                .padding(0.dp)
                .background(Color.Yellow)
                .weight(1f),
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true,
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(
                        onClick = { text = "" },
                        modifier = Modifier
                            // 放在padding之前 点击上下区域也有效果
                            .clickable { text = "" }
                            .padding(0.dp, 12.dp)
                            .size(24.dp, 24.dp)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(Color.Gray)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(12.dp, 12.dp),
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            }
        )

        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = ""
            )
        }

    }
}