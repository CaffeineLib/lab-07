package com.example.throwlab7outanddofromscratch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DragonScreen() {
    var rotationAngle by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dragon View", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        AsyncImage(
            model = "https://cdn-icons-png.flaticon.com/512/4133/4133398.png",
            contentDescription = "Dragon",
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(rotationZ = rotationAngle)
                .clickable { rotationAngle = (rotationAngle + 90f) % 360f }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "(Tap dragon to rotate 90°)")
    }
}