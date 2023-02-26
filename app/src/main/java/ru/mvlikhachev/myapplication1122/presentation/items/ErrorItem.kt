package ru.mvlikhachev.myapplication1122.presentation.screen.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.mvlikhachev.myapplication1122.presentation.ui.theme.MyApplication1122Theme

@Composable
fun ErrorItem(
    errorMessage: String?,
    onButtonClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0x4DFF0000))
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Text(
                text = errorMessage ?: "Oh... something went wrong",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        
        Button(onClick = {
            scope.launch {
                onButtonClick()
            }
            }
        ) {
            Text(text = "Refresh")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    MyApplication1122Theme {
        ErrorItem("Oh... something went wrong") {}
    }
}