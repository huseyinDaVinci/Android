package barin.com.searchtipsapplication.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.data.entity.User;
import barin.com.searchtipsapplication.presentation.di.component.DaggerTipComponent;
import barin.com.searchtipsapplication.presentation.di.component.GetComponent;
import barin.com.searchtipsapplication.presentation.di.component.TipComponent;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import barin.com.searchtipsapplication.presentation.model.TParameters;
import barin.com.searchtipsapplication.presentation.view.fragment.TipDetailFragment;
import barin.com.searchtipsapplication.presentation.view.fragment.TipListFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TipListActivity extends BaseActivity
    implements GetComponent, TipListFragment.TipListSelectedListener,
    TipListFragment.LayoutTwoPaneDeterminationInterface {

  @Bind(R.id.my_toolbar) Toolbar toolbar;

  public static final String PARAMETER_TAG = "tip_search_parameters";
  private TipComponent tipComponent;
  private boolean mTwoPane;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_tlist);
    ButterKnife.bind(this);

    setupInjector();
    setupToolbar();

    TParameters tParameters = getIntent().getParcelableExtra(PARAMETER_TAG);
    if (savedInstanceState == null) {
      addFragment(R.id.frameLayout, TipListFragment.newInstance(tParameters));
    }
  }

  @Override protected void setupToolbar() {
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setLogo(R.mipmap.ic_launcher);
      getSupportActionBar().setDisplayUseLogoEnabled(true);
      getSupportActionBar().setTitle(getTitle());
      toolbar.setTitleTextColor(Color.WHITE);
    }
  }

  private void setupInjector() {
    this.tipComponent = DaggerTipComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  public static Intent getCallingIntent(Context context, ITParameters itParameters) {
    Intent tListActivityLauncherIntent = new Intent(context, TipListActivity.class);
    tListActivityLauncherIntent.putExtra(TipListActivity.PARAMETER_TAG, (Parcelable) itParameters);
    return tListActivityLauncherIntent;
  }

  @Override public TipComponent getComponent() {
    return tipComponent;
  }

  @Override public void onTipSelected(User user) {
    if (mTwoPane) {  //according two pane or not replace fragment or navigate activity.
      replaceFragment(R.id.item_detail_container, TipDetailFragment.newInstance(user));
    } else {
      navigator.navigateToTipDetailActivity(this, user);
    }
  }

  @Override public void setPaneStyle(boolean value) {
    mTwoPane = value;  //know tablet or phone.
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }
}
