package self.yue.basejava.vipe.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseFragmentPresenter<V extends FragmentContract.View, I extends FragmentContract.Interactor>
        implements FragmentContract.Presenter<V, I> {
  private V mView;
  private I mInteractor;

  public BaseFragmentPresenter() {
    mView = initView();
    mInteractor = initInteractor();

    mView.setPresenter(this);
  }

  @Override
  public Fragment getFragment() {
    return (Fragment) mView;
  }

  @Override
  public void dispose() {
    mInteractor.dispose();
  }

  protected V getView() {
    return mView;
  }

  protected I getInteractor() {
    return mInteractor;
  }

  protected abstract V initView();

  protected abstract I initInteractor();
}
