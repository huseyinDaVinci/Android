package barin.com.searchtipsapplication;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import barin.com.searchtipsapplication.presentation.model.TParameters;
import barin.com.searchtipsapplication.presentation.view.activity.TipListActivity;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by machiavelli on 6/24/2016.
 */
public class TipListActivityWithParamsTest
    extends ActivityInstrumentationTestCase2<TipListActivity> {
  private TipListActivity tipListActivity;

  public TipListActivityWithParamsTest(Class activityClass) {
    super(activityClass);
  }

  public TipListActivityWithParamsTest() {
    super(TipListActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    setActivityIntent(getTipListActivityLauncherIntent());
    tipListActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  private Intent getTipListActivityLauncherIntent() {
    TParameters tParameters =
        new TParameters.Builder("40.7463956,-73.9852992").near(null).limit(10).offSet(0).build();
    Intent intentLaunchActivity =
        TipListActivity.getCallingIntent(getInstrumentation().getTargetContext(), tParameters);
    return intentLaunchActivity;
  }

  public void testFragmentAddedOrNotAccordingToParameters() {
    Fragment tipListFragment =
        tipListActivity.getFragmentManager().findFragmentById(R.id.frameLayout);
    assertThat(tipListFragment, is(notNullValue()));
  }

  public void testTipListActivityTitle() {
    String title = tipListActivity.getTitle().toString();
    assertThat(title,is("TIP LIST"));
  }


}
