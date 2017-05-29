package barin.com.searchtipsapplication.domain.repository;

import barin.com.searchtipsapplication.data.entity.TipResponse;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import rx.Observable;


public interface GetTipListRepository {
  Observable<TipResponse> getTipList(ITParameters itParameters);
}
