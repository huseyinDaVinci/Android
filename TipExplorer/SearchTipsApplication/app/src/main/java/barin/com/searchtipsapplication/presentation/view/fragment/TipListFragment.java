package barin.com.searchtipsapplication.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.data.entity.TipResponse;
import barin.com.searchtipsapplication.data.entity.User;
import barin.com.searchtipsapplication.domain.interactor.usecase.UseCaseWithParams;
import barin.com.searchtipsapplication.presentation.di.component.TipComponent;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import barin.com.searchtipsapplication.presentation.model.TParameters;
import barin.com.searchtipsapplication.presentation.view.adapter.DividerItemDecoration;
import barin.com.searchtipsapplication.presentation.view.adapter.TipsAdapter;
import barin.com.searchtipsapplication.presentation.view.adapter.UsersLayoutManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Subscriber;

public class TipListFragment extends BaseFragment {

  @Bind(R.id.tips_recycler) RecyclerView tipsRecyclerView;
  @Bind(R.id.view_progress_tips_loading) View processView;
  @Bind(R.id.btn_reload) Button buttonReload;

  @Inject TipsAdapter tipsAdapter;
  @Inject @Named("tipList") UseCaseWithParams getTipListCase;

  @OnClick(R.id.btn_reload) void reload() {
    loadTipList();
  }

  public static final String PARAMETER_TAG = "tip_search_parameters";
  private TParameters tipParameters;
  private TipListSelectedListener tipListSelectedListener;
  private LayoutTwoPaneDeterminationInterface layoutTwoPaneDeterminationInterface;

  public interface LayoutTwoPaneDeterminationInterface {
    void setPaneStyle(final boolean value);
  }

  public interface TipListSelectedListener {
    void onTipSelected(final User user);
  }

  public static TipListFragment newInstance(ITParameters tipParameters) {
    TipListFragment tipListFragment = new TipListFragment();
    Bundle args = new Bundle();
    args.putParcelable(PARAMETER_TAG, (Parcelable) tipParameters);
    tipListFragment.setArguments(args);
    return tipListFragment;
  }

  public TipListFragment() {
    setRetainInstance(true);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getComponent(TipComponent.class).inject(this);

    if (getArguments() != null) {
      tipParameters = getArguments().getParcelable(PARAMETER_TAG);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    final View fragmentView = inflater.inflate(R.layout.fragment_tlist, container, false);

    ButterKnife.bind(this, fragmentView);
    setupViews(fragmentView);
    setupRecyclerView();
    return fragmentView;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //load the Tips information from here....
    loadTipList();
  }

  private void loadTipList() {
    if (isInternetAvailable()) {
      showProcess(true);
      getTipListCase.execute(new TipListSubscriber(), tipParameters);
    } else {
      showInfoMessage(getString(R.string.no_net_connection));
      showReload(true);
    }
  }

  private void showProcess(boolean value) {
    if (value) {
      processView.setVisibility(View.VISIBLE);
    } else {
      processView.setVisibility(View.GONE);
    }
  }

  private void showReload(boolean value) {
    if (value) {
      buttonReload.setVisibility(View.VISIBLE);
    } else {
      buttonReload.setVisibility(View.GONE);
    }
  }

  private void setupViews(View fragmentView) {
    if (fragmentView.findViewById(R.id.item_detail_container) != null) {
      layoutTwoPaneDeterminationInterface.setPaneStyle(true);
    } else {
      layoutTwoPaneDeterminationInterface.setPaneStyle(false);
    }
  }

  private void setupRecyclerView() {
    tipsAdapter.setOnItemClickListener(onItemClickListener);
    tipsRecyclerView.setLayoutManager(
        new UsersLayoutManager(getActivity().getApplicationContext()));
    tipsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), null));
    tipsRecyclerView.setAdapter(tipsAdapter);
  }

  private TipsAdapter.OnItemClickListener onItemClickListener =
      tip -> tipListSelectedListener.onTipSelected(tip.getUser());

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);

    if (activity instanceof TipListSelectedListener
        && activity instanceof LayoutTwoPaneDeterminationInterface) {
      tipListSelectedListener = (TipListSelectedListener) activity;
      layoutTwoPaneDeterminationInterface = (LayoutTwoPaneDeterminationInterface) activity;
    } else {
      throw new RuntimeException(
          activity.toString() + " must implement OnFragmentInteractionListener");
    }
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof TipListSelectedListener
        && context instanceof LayoutTwoPaneDeterminationInterface) {
      tipListSelectedListener = (TipListSelectedListener) context;
      layoutTwoPaneDeterminationInterface = (LayoutTwoPaneDeterminationInterface) context;
    } else {
      throw new RuntimeException(
          context.toString() + " must implement OnFragmentInteractionListener");
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    tipListSelectedListener = null;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
    getTipListCase.unsubscribe();
  }

  private boolean isInternetAvailable() {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.isConnectedOrConnecting());
  }

  private class TipListSubscriber extends Subscriber<TipResponse> {
    @Override public void onCompleted() {
      //hide loading...
      showProcess(false);
      showReload(false);
    }

    @Override public void onError(Throwable e) {
      showProcess(false);
      showReload(true);
      showInfoMessage(e.getMessage());
    }

    @Override public void onNext(TipResponse tipResponse) {
      if (tipResponse.getMeta().getCode() == 200) {
        tipsAdapter.setTipCollection(tipResponse.getTips());
      } else {
        showInfoMessage(tipResponse.getMeta().toString());
        showReload(true);
      }
    }
  }
}
