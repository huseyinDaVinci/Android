package barin.com.searchtipsapplication.presentation.di.module;

import barin.com.searchtipsapplication.domain.interactor.usecase.GetTipListCase;
import barin.com.searchtipsapplication.domain.interactor.usecase.UseCaseWithParams;
import barin.com.searchtipsapplication.presentation.di.component.PerActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;


@Module public class TipModule {
  @Provides @PerActivity @Named("tipList") UseCaseWithParams provideTipListCase(
      GetTipListCase getTipListCase) {
    return getTipListCase;
  }
}
