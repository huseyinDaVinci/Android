package barin.com.searchtipsapplication.presentation.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import barin.com.searchtipsapplication.application.TipApplication;
import barin.com.searchtipsapplication.presentation.di.component.ApplicationComponent;
import barin.com.searchtipsapplication.presentation.di.module.ActivityModule;
import barin.com.searchtipsapplication.presentation.navigation.Navigator;
import javax.inject.Inject;

/**
 * Base activity is used for activities for common methods or properties
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Inject Navigator navigator;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }

  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  protected void replaceFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.replace(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((TipApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  protected abstract void setupToolbar();
}
