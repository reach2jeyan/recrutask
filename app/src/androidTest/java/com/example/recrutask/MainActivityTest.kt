package com.example.recrutask

/**
 * Using this file to  declare all the variable resource ids and the texts that are used throughout the tests in other files.
 * This will help us not do a considerable change in many files if there are text changes. Changing in this file would do
 */
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    val firstToggle = onView(withId(R.id.toggleButton))
    val firstTextview =  onView(withId(R.id.textView3))
    val offState = "OFF"
    val onClickstate = "ON"
    val defaultText = "Default"
    val onClickText = "okay"
    val nextActivity = onView(withText("Move"))
    val secondaActivityDefaultText = "Check me"

}


