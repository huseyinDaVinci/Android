package barin.com.searchtipsapplication.presentation.di.component;

import android.app.Activity;
import barin.com.searchtipsapplication.presentation.di.module.ActivityModule;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //expose the activity to sub graphs
  Activity activity();
}