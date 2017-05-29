package barin.com.searchtipsapplication;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import barin.com.searchtipsapplication.presentation.view.activity.MainActivity;
import barin.com.searchtipsapplication.presentation.view.activity.TipListActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by machiavelli on 6/24/2016.
 */
@RunWith(AndroidJUnit4.class) public class MainActivityTest {

  @Rule public ActivityTestRule<MainActivity> mActivityRule =
      new ActivityTestRule(MainActivity.class);

  @Test public void testTipListActivityIntentIsShowed() {
    // Making sure the error message is not displayed by default
    Intents.init();
    onView(withId(R.id.btn_LoadData)).perform(click());
    intended(hasComponent(TipListActivity.class.getName()));
    Intents.release();
  }
}
