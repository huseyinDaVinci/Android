package barin.com.searchtipsapplication.application;

import android.app.Application;
import barin.com.searchtipsapplication.BuildConfig;
import barin.com.searchtipsapplication.presentation.di.component.ApplicationComponent;
import barin.com.searchtipsapplication.presentation.di.component.DaggerApplicationComponent;
import barin.com.searchtipsapplication.presentation.di.module.ApplicationModule;
import timber.log.Timber;

public class TipApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    setupApplication();
  }

  private void setupApplication() {
    setupInjectors();
    setupLogger();
  }

  private void setupInjectors() {
    this.applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  private void setupLogger() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree() {
        @Override public void e(String message, Object... args) {
          super.e("@@" + message, args);
        }

        @Override public void i(String message, Object... args) {
          super.i("@@" + message, args);
        }

        @Override public void d(String message, Object... args) {
          super.d("@@" + message, args);
        }
      });
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}


