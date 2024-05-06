package com.example.talkinggata

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LivePetTest {

    private lateinit var scenario: ActivityScenario<LivePet>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(LivePet::class.java)
    }

    @Test
    fun testFeedButtonClicked() {
        onView(withId(R.id.feedBtn)).perform(click())

        onView(withId(R.id.petImage)).check(matches(withDrawable(R.drawable.dogeating)))
        onView(withId(R.id.fedStat)).check(matches(withText("5")))
    }

    private fun withDrawable(dogeating: Int): Matcher<in View>? {
        TODO("Not yet implemented")
    }

    @Test
    fun testCleanButtonClicked() {
        onView(withId(R.id.cleanBtn)).perform(click())

        onView(withId(R.id.petImage)).check(matches(withDrawable(R.drawable.dogclean)))
        onView(withId(R.id.cleanStat)).check(matches(withText("5")))
    }

    @Test
    fun testPlayButtonClicked() {
        onView(withId(R.id.playBtn)).perform(click())

        onView(withId(R.id.petImage)).check(matches(withDrawable(R.drawable.dogplaying)))
        onView(withId(R.id.boredStat)).check(matches(withText("5")))
    }

    // Add more tests as needed
}
