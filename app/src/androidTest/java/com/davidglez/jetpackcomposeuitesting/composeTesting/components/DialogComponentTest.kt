package com.davidglez.jetpackcomposeuitesting.composeTesting.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.davidglez.jetpackcomposeuitesting.components.AddTaskDialog
import org.junit.Rule
import org.junit.Test

/**
 * Created by davidgonzalez on 23/06/23
 */
class DialogComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_thenShowDialog() {
        composeTestRule.setContent {
            AddTaskDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetAFalse_thenShowDialog() {
        composeTestRule.setContent {
            AddTaskDialog(show = false, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }
}