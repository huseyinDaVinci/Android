package barin.com.searchtipsapplication.presentation.di.component;

import android.content.Context;
import barin.com.searchtipsapplication.domain.executor.PostExecutionThread;
import barin.com.searchtipsapplication.domain.executor.ThreadExecutor;
import barin.com.searchtipsapplication.domain.repository.GetTipListRepository;
import barin.com.searchtipsapplication.presentation.di.module.ApplicationModule;
import barin.com.searchtipsapplication.presentation.view.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton  //actually this is a scope for this container
@Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);



  //this is needed for sub graphs to use these objects
  Context context();

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();

  GetTipListRepository getTipListRepository();
}
