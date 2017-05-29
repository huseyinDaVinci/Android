package barin.com.searchtipsapplication.domain.interactor.usecase;

import barin.com.searchtipsapplication.domain.executor.PostExecutionThread;
import barin.com.searchtipsapplication.domain.executor.ThreadExecutor;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * is a base class for case with execute and unsubscribe methods
 */
public abstract class UseCaseWithParams {

  public abstract void execute(Subscriber registerTokenSubscriber, Object object);

  public final ThreadExecutor threadExecutor;
  public final PostExecutionThread postExecutionThread;

  public Subscription subscription = Subscriptions.empty();

  protected UseCaseWithParams(ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
  }


  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
