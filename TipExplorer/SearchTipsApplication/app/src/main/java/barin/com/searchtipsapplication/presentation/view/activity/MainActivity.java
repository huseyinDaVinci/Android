package barin.com.searchtipsapplication.presentation.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.presentation.model.TParameters;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

  @Bind(R.id.btn_LoadData) Button btnLoadData;
  @Bind(R.id.toolbar) Toolbar myToolbar;

  @OnClick(R.id.btn_LoadData) void loadData() {

    //this is just to try the application these parameters can be acquired dynamically from user.
    TParameters tParameters =
        new TParameters.Builder("40.7463956,-73.9852992").near(null).limit(10).offSet(0).build();

    navigator.navigateToTipListActivity(this, tParameters);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupToolbar();
  }

  @Override protected void setupToolbar() {
    setSupportActionBar(myToolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setLogo(R.mipmap.ic_launcher);
      getSupportActionBar().setDisplayUseLogoEnabled(true);
      getSupportActionBar().setTitle(getTitle());
      myToolbar.setTitleTextColor(Color.WHITE);
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }
}
