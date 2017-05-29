package barin.com.searchtipsapplication.presentation.di.module;

import android.content.Context;
import barin.com.searchtipsapplication.application.TipApplication;
import barin.com.searchtipsapplication.data.executor.JobExecutor;
import barin.com.searchtipsapplication.data.repository.GetTipListRepositoryImpl;
import barin.com.searchtipsapplication.domain.executor.PostExecutionThread;
import barin.com.searchtipsapplication.domain.executor.ThreadExecutor;
import barin.com.searchtipsapplication.domain.repository.GetTipListRepository;
import barin.com.searchtipsapplication.presentation.thread.UIThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;


@Module public class ApplicationModule {

  private final TipApplication tipApplication;

  public ApplicationModule(TipApplication tipApplication) {
    this.tipApplication = tipApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.tipApplication;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }


  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }


  @Provides @Singleton public GetTipListRepository provideGetTipListRepository() {
    return new GetTipListRepositoryImpl();
  }



}
