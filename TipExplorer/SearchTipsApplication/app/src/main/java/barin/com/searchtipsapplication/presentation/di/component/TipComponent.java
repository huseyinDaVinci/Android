package barin.com.searchtipsapplication.presentation.di.component;

import barin.com.searchtipsapplication.presentation.di.module.ActivityModule;
import barin.com.searchtipsapplication.presentation.di.module.TipModule;
import barin.com.searchtipsapplication.presentation.view.fragment.TipDetailFragment;
import barin.com.searchtipsapplication.presentation.view.fragment.TipListFragment;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, TipModule.class
}) public interface TipComponent extends ActivityComponent {

  void inject(TipListFragment tipListFragment);

  void inject(TipDetailFragment tipDetailsFragment);
}
