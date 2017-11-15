package io.github.wenzla.testapp;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;

public class GameActivitiesInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void GameActivityTextLocationTest() {
        onView(withId(R.id.signature_canvas)).check(isCompletelyBelow(withId(R.id.status)));
        onView(withId(R.id.signature_canvas)).check(isCompletelyAbove(withId(R.id.resetBoard)));
        onView(withId(R.id.button2)).check(isCompletelyLeftOf(withId(R.id.resetBoard)));
    }

    @Test
    public void GameActivityTextContentTest() {
        assertTrue(true);
    }


}
