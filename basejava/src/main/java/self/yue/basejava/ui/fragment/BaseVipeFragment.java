package self.yue.basejava.ui.fragment;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import self.yue.basejava.ui.activity.BaseFragmentActivity;
import self.yue.basejava.vipe.fragment.FragmentContract;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseVipeFragment<P extends FragmentContract.Presenter> extends BaseFragment
        implements FragmentContract.View<P> {
  private P mPresenter;

  @Override
  public void showMessage(String message) {
    getBaseActivity().showMessage(message);
  }

  @Override
  public void showMessage(@StringRes int messageResId) {
    getBaseActivity().showMessage(messageResId);
  }

  @Override
  public void showLoadingDialog(String loadingMessage) {
    getBaseActivity().showLoadingDialog(loadingMessage);
  }

  @Override
  public void dismissLoadingDialog() {
    getBaseActivity().dismissLoadingDialog();
  }

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  protected void replace(Fragment fragment, String tag) {
    if (getActivity() instanceof BaseFragmentActivity) {
      ((BaseFragmentActivity) getActivity()).replace(fragment, tag);
    }
  }

  protected void replaceWithCustomAnimation(Fragment fragment, String tag,
                                            int enter, int exit, int popEnter, int popExit) {
    if (getActivity() instanceof BaseFragmentActivity) {
      ((BaseFragmentActivity) getActivity()).replaceWithCustomAnimation(fragment, tag, enter, exit, popEnter, popExit);
    }
  }
}
