package barin.com.searchtipsapplication.data.repository;

import barin.com.searchtipsapplication.application.Constants;
import barin.com.searchtipsapplication.application.util.AppUtil;
import barin.com.searchtipsapplication.data.entity.TipResponse;
import barin.com.searchtipsapplication.data.net.TRestClient;
import barin.com.searchtipsapplication.domain.repository.GetTipListRepository;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * aim is to provide Tip Response as stream.
 */
@Singleton public class GetTipListRepositoryImpl implements GetTipListRepository {

  @Inject public GetTipListRepositoryImpl() {
  }

  @Override public Observable<TipResponse> getTipList(ITParameters itParameters) {
    AppUtil.checkForNull(itParameters, "parameters==null");
    TRestClient.TSquareApiInterface service =
        TRestClient.getTSquareApiInterface(Constants.BASE_URL_FOURSQUARE);

    AppUtil.checkForNull(service, "restservice==null");
    return service.searchTips(Constants.CLIENT_ID, Constants.CLIENT_SECRET, Constants.V,
        itParameters.getLL());
  }
}
