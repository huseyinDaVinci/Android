package barin.com.searchtipsapplication.presentation.di.module;

import android.app.Activity;
import barin.com.searchtipsapplication.presentation.di.component.PerActivity;
import dagger.Module;
import dagger.Provides;


@Module public class ActivityModule {

  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity Activity activity() {
    return this.activity;
  }
}
