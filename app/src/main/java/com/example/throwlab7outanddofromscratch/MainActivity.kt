package com.example.throwlab7outanddofromscratch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.throwlab7outanddofromscratch.ui.theme.ThrowLab7OutAndDoFromScratchTheme

/* Lab 7 made absolutley no sense.
With the help of Gemini AI and an hour of back and forth I now understand the concepts of Navigation.
What you want to accomplish in lab 7 ID but at least ive aquired the learnings.
If you wont accept this i dont care - ive got what i needed; please make better labs.

Please take solace in that i did not cheat my way through your lab with AI.

Ben Mazor
*/


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThrowLab7OutAndDoFromScratchTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    myApp(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun myApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Column(modifier = modifier.fillMaxSize()) {
        // Tab row acting like website header buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate("wizard") }) {
                Text("Turn The Wizard")
            }
            Button(onClick = { navController.navigate("dragon") }) {
                Text("Spin The Dragon")
            }
        }

        // NavHost swapping views below the buttons
        NavHost(
            navController = navController,
            startDestination = "wizard",
            modifier = Modifier.fillMaxSize()
        ) {
            composable("wizard") { WizardScreen() }
            composable("dragon") { DragonScreen() }
        }
    }
}

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

        // Clickable wizard icon that flips horizontally
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Wizard",
            modifier = Modifier
                .size(120.dp)
                .graphicsLayer(scaleX = if (isFacingRight) 1f else -1f)
                .clickable { isFacingRight = !isFacingRight }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "(Tap wizard to flip)")
    }
}

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

        // Clickable dragon icon that rotates 90 degrees on click
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Dragon",
            modifier = Modifier
                .size(120.dp)
                .graphicsLayer(rotationZ = rotationAngle)
                .clickable { rotationAngle = (rotationAngle + 90f) % 360f }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "(Tap dragon to rotate 90°)")
    }
}
