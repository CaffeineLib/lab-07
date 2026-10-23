package com.example.lab_7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab_7.ui.theme.Lab7Theme
import androidx.navigation.NavController


// I really have no clue what your trying to do here. These labs are nonsense. instead of giving us copy paste labs why not teach us something.
// Ben Mazor



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme (
                onCreate(
                    //step 4 makes no sense
                ){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //greetings

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7Theme {
        Greeting("Android")
    }
}