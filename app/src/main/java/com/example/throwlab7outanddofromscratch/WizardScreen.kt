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
fun WizardScreen() {
    var isFacingRight by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Wizard View", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        AsyncImage(
            model = "https://static.vecteezy.com/system/resources/previews/023/783/837/non_2x/wizard-logo-icon-design-vector.jpg",
            contentDescription = "Wizard",
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(scaleX = if (isFacingRight) 1f else -1f)
                .clickable { isFacingRight = !isFacingRight }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "(Tap wizard to flip)")
    }
}