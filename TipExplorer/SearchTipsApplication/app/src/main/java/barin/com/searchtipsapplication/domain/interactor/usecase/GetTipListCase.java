package barin.com.searchtipsapplication.domain.interactor.usecase;

import barin.com.searchtipsapplication.domain.executor.PostExecutionThread;
import barin.com.searchtipsapplication.domain.executor.ThreadExecutor;
import barin.com.searchtipsapplication.domain.repository.GetTipListRepository;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import javax.inject.Inject;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * this case is responsible for getting tips  that longitude latitude are provided.
 */
public class GetTipListCase extends UseCaseWithParams {

  private GetTipListRepository getTipListRepository;

  @Inject
  protected GetTipListCase(GetTipListRepository getTipListRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.getTipListRepository = getTipListRepository;
  }

  @Override public void execute(Subscriber getTipsSubscriber, Object object) {
    if (!(object instanceof ITParameters)) {
      throw new RuntimeException("object not instance of required parameter");
    }

    this.subscription = getTipListRepository.getTipList((ITParameters) object)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(getTipsSubscriber);
  }
}
