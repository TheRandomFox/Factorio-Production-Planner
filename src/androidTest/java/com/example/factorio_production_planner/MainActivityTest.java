package com.example.factorio_production_planner;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.productionLinesTextView), withText("My Production Lines"),
                        withParent(allOf(withId(R.id.mainConstraintLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.productionLinesTextView), withText("My Production Lines"),
                        withParent(allOf(withId(R.id.mainConstraintLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        textView2.check(matches(withText("My Production Lines")));

        ViewInteraction button = onView(
                allOf(withId(R.id.viewRecipesButton), withText("BROWSE RECIPE LIST"),
                        withParent(allOf(withId(R.id.mainConstraintLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.viewRecipesButton), withText("BROWSE RECIPE LIST"),
                        withParent(allOf(withId(R.id.mainConstraintLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));
    }
}
