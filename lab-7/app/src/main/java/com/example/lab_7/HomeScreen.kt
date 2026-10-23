package com.example.lab_7
import androidx.navigation.NavController
import androidx.compose.runtime.Composable

class HomeScreen {
    @Composable
    fun HomeScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "FormulaZero Home",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("races")
                },
                modifier = Modifier.testTag("raceButton") // for testing
            ) {
                Text("Upcoming Races")
            }
        }
    }
}