package es.ulpgc.eite.da.basicquiz;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

  @Rule
  public ActivityScenarioRule<QuestionActivity> mActivityScenarioRule =
      new ActivityScenarioRule<>(QuestionActivity.class);

  @Test
  public void exampleInstrumentedTest1() {
    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction textView = onView(
        allOf(withId(R.id.questionText), withText("Question #1: True"),
            withParent(withParent(withId(android.R.id.content))),
            isDisplayed()));
    textView.check(matches(withText("Question #1: True")));

    ViewInteraction textView2 = onView(
        allOf(withId(R.id.replyText), withText("???"),
            withParent(withParent(withId(android.R.id.content))),
            isDisplayed()));
    textView2.check(matches(withText("???")));

    ViewInteraction materialButton = onView(
        allOf(withId(R.id.trueButton), withText("True"),
            childAtPosition(
                allOf(withId(R.id.linearLayout),
                    childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        1)),
                0),
            isDisplayed()));
    materialButton.perform(click());

    ViewInteraction textView3 = onView(
        allOf(withId(R.id.questionText), withText("Question #1: True"),
            withParent(withParent(withId(android.R.id.content))),
            isDisplayed()));
    textView3.check(matches(withText("Question #1: True")));

    ViewInteraction textView4 = onView(
        allOf(withId(R.id.questionText), withText("Question #1: True"),
            withParent(withParent(withId(android.R.id.content))),
            isDisplayed()));
    textView4.check(matches(withText("Question #1: True")));

    ViewInteraction textView5 = onView(
        allOf(withId(R.id.replyText), withText("Correct"),
            withParent(withParent(withId(android.R.id.content))),
            isDisplayed()));
    textView5.check(matches(withText("Correct")));
  }

  private static Matcher<View> childAtPosition(
      final Matcher<View> parentMatcher, final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent)
            && view.equals(((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}
