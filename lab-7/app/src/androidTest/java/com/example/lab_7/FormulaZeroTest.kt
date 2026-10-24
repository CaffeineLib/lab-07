package com.example.lab_7

package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // Navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // Verify race screen is displayed
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // Enter race location into the text field
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // Click the add button
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // Verify the race appears in the list
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Return to home screen using the back button
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify we are back on the home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}