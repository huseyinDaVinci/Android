package barin.com.searchtipsapplication.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.application.util.AppUtil;
import barin.com.searchtipsapplication.data.entity.User;
import barin.com.searchtipsapplication.presentation.di.component.TipComponent;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TipDetailFragment extends BaseFragment {

  @Bind(R.id.user_name) TextView txtUserName;
  @Bind(R.id.user_surname) TextView txtUserSurname;
  @Bind(R.id.gender) TextView txtGender;

  private OnFragmentInteractionListener mListener;
  public static final String USER_TAG = "tip_user";

  public static TipDetailFragment newInstance(User user) {

    TipDetailFragment fragment = new TipDetailFragment();
    Bundle args = new Bundle();
    args.putParcelable(USER_TAG, user);
    fragment.setArguments(args);
    return fragment;
  }

  public TipDetailFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(TipComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    final View fragmentView = inflater.inflate(R.layout.fragment_tdetail, container, false);
    ButterKnife.bind(this, fragmentView);
    return fragmentView;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (getArguments() != null) {
      loadUserInformation(getArguments().getParcelable(USER_TAG));
    }
  }

  private void loadUserInformation(@Nullable User user) {
    AppUtil.checkForNull(user, "user==null");
    txtUserName.setText(user.getFirstName());
    txtUserSurname.setText(user.getLastName());
    txtGender.setText(user.getGender());
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(
          context.toString() + " must implement OnFragmentInteractionListener");
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  public interface OnFragmentInteractionListener {
  }
}
