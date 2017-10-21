package self.yue.basejava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import self.yue.basejava.ui.activity.BaseActivity;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseFragment extends Fragment {
  private Unbinder mUnbinder;

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResId(), container, false);
    mUnbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initViews();
    setEventListeners();
  }

  @Override
  public void onDestroyView() {
    mUnbinder.unbind();
    super.onDestroyView();
  }

  public void onBackPressed() {
    if (getFragmentManager().getBackStackEntryCount() > 0) {
      getFragmentManager().popBackStack();
    } else
      finishActivity();
  }

  protected abstract int getLayoutResId();

  protected BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  protected void finishActivity() {
    getActivity().finish();
  }

  protected void initViews() {
  }

  protected void setEventListeners() {
  }
}
