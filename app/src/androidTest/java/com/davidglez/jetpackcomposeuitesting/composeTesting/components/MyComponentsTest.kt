package com.davidglez.jetpackcomposeuitesting.composeTesting.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextInputSelection
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import com.davidglez.jetpackcomposeuitesting.components.MyComponents
import org.junit.Rule
import org.junit.Test

/**
 * Created by davidgonzalez on 23/06/23
 */
class MyComponentsTest {

    //Compose Rules
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            MyComponents()
        }
        //De esta manera podemos acceder a los componentes
        //Finder
        composeTestRule.onNodeWithText("David", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("addIcon")

        //busca todos los componentes con el mismo tag
        composeTestRule.onAllNodesWithText("a") // busca las coincidencias
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //Actions
        composeTestRule.onNodeWithText("David", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("David").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeRight()
            swipeLeft()
        }
        composeTestRule.onNodeWithText("David").performScrollTo()
        composeTestRule.onNodeWithText("David").performImeAction() //Ime action del teclado
        composeTestRule.onNodeWithText("David").performTextClearance() // borrar el texto del textfield
        composeTestRule.onNodeWithText("David").performTextInput("hola") // este texto se lo pondra el textfield
        composeTestRule.onNodeWithText("David").performTextReplacement("replace")
        composeTestRule.onNodeWithText("David")

        //Assertions
        composeTestRule.onNodeWithText("David").assertExists()
        composeTestRule.onNodeWithText("David").assertDoesNotExist()
        composeTestRule.onNodeWithText("David").assertContentDescriptionContains("hola")
        composeTestRule.onNodeWithText("David").assertContentDescriptionEquals("hola")
        composeTestRule.onNodeWithText("David").assertIsDisplayed()
        composeTestRule.onNodeWithText("David").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("David").assertIsEnabled()
        composeTestRule.onNodeWithText("David").assertIsNotEnabled()
        composeTestRule.onNodeWithText("David").assertIsSelected()
        composeTestRule.onNodeWithText("David").assertIsNotSelected()
        composeTestRule.onNodeWithText("David").assertIsFocused()
        composeTestRule.onNodeWithText("David").assertIsNotFocused()
        composeTestRule.onNodeWithText("David").assertIsOn()
        composeTestRule.onNodeWithText("David").assertIsOff()
        composeTestRule.onNodeWithText("David").assertTextEquals("")
        composeTestRule.onNodeWithText("David").assertTextContains("value")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsAris() {
        composeTestRule.setContent {
            MyComponents()
        }

        composeTestRule.onNodeWithText("David", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("David")

    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            MyComponents()
        }

        composeTestRule.onNodeWithText("textFieldName").performTextReplacement("Pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Pepe")
    }
}