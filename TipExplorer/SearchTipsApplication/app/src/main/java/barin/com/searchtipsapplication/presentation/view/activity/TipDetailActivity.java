package barin.com.searchtipsapplication.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.data.entity.User;
import barin.com.searchtipsapplication.presentation.di.component.DaggerTipComponent;
import barin.com.searchtipsapplication.presentation.di.component.GetComponent;
import barin.com.searchtipsapplication.presentation.di.component.TipComponent;
import barin.com.searchtipsapplication.presentation.view.fragment.TipDetailFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TipDetailActivity extends BaseActivity
    implements GetComponent, TipDetailFragment.OnFragmentInteractionListener {

  @Bind(R.id.my_toolbar) Toolbar toolbar;
  public static final String USER_TAG = "tip_user";
  private TipComponent tipComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tdetail);
    ButterKnife.bind(this);

    setupInjector();
    setupToolbar();

    if (getIntent().hasExtra(USER_TAG)) {
      User user = getIntent().getParcelableExtra(USER_TAG);
      if (user != null) {
        addFragment(R.id.fragment_tip_detail, TipDetailFragment.newInstance(user));
      }
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

  public static Intent getCallingIntent(Context context, User user) {
    Intent detailActivityLauncherIntent = new Intent(context, TipDetailActivity.class);
    detailActivityLauncherIntent.putExtra(USER_TAG, user);
    return detailActivityLauncherIntent;
  }

  private void setupInjector() {
    this.tipComponent = DaggerTipComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override public Object getComponent() {
    return tipComponent;
  }
}
