package com.example.recrutask
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not



import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import androidx.test.InstrumentationRegistry.getTargetContext

import android.content.ComponentName
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.intent.Intents


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    val elements = MainActivityTest()
    /**Declared all the texts and resource id to be used in a file,
     so as to accomodate changes in future in one file itself **/


    @Rule
    @JvmField
    /** Launching the default activity for the instrumented tests to start **/
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java, false, true
    )


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.recrutask", appContext.packageName)



    }
    @Test
    fun checkTextview() {
        /**not matcher is used to assert text that should not match a specific. */
        onView(withId(R.id.editTextTextPassword)).check(ViewAssertions.matches(not(withText("Hopin"))))

    }
    @Test
    fun checkFirstToggle() {
        elements.firstToggle.check(ViewAssertions.matches(withText(elements.offState)))
        elements.firstTextview.check(ViewAssertions.matches(withText(elements.defaultText)))
        elements.firstToggle.perform(ViewActions.click())
        elements.firstToggle.check(ViewAssertions.matches(not(withText(elements.offState))))
        elements.firstToggle.check(ViewAssertions.matches(withText(elements.onClickstate)))
        elements.firstTextview.check(ViewAssertions.matches(withText(elements.onClickText)))
        elements.firstToggle.perform(ViewActions.click())
        elements.firstToggle.check(ViewAssertions.matches(withText(elements.offState)))
        elements.firstTextview.check(ViewAssertions.matches(withText(elements.defaultText)))

    }
    @Test
    fun testActivitylaunch() {
        /** Using the intents to basically match if a particular activity has been launched. Without init, throws a java exception **/
        Intents.init()
        elements.nextActivity.perform(ViewActions.click())
        intended(hasComponent(MainActivity2::class.java.getName()))


    }

    @Test
    fun testDynamictext() {
        /** Given the default text is present in the next screen
         * when the text is changed in the first screen
         * then check if the default text is changed in the next screen and is same as first screen*/
        elements.nextActivity.perform(ViewActions.click())
        onView(withText(elements.secondaActivityDefaultText)).check(ViewAssertions.matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.editTextTextPassword)).perform(ViewActions.clearText())
        onView(withId(R.id.editTextTextPassword)).perform(ViewActions.typeText("dynamic text"))
        Espresso.closeSoftKeyboard()
        elements.nextActivity.perform(ViewActions.click())
        onView(withText("dynamic text")).check(ViewAssertions.matches(isDisplayed()))
    }
}