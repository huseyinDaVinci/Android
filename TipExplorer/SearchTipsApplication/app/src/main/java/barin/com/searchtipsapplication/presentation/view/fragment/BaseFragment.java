package barin.com.searchtipsapplication.presentation.view.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.presentation.di.component.GetComponent;

/**
 * Base fragment for fragments for sharing common methods and properties
 */
public class BaseFragment extends Fragment {

  private AlertDialog mAlertDialog;
  private AlertDialog.Builder mBuilder;




  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBuilder = new AlertDialog.Builder(getActivity());
    mBuilder.setTitle(R.string.info_message);
    mBuilder.setCancelable(true);
    mBuilder.setPositiveButton("OK", (dialog, which) -> {
      mAlertDialog.dismiss();
    });
    mAlertDialog = mBuilder.create();
  }

  protected void showInfoMessage(String messge) {
    mAlertDialog.setMessage(messge);
    mAlertDialog.show();
  }

  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((GetComponent<C>) getActivity()).getComponent());
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mBuilder = null;
    mAlertDialog = null;
  }
}
