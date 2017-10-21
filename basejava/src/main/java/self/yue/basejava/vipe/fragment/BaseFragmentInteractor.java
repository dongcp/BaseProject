package self.yue.basejava.vipe.fragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseFragmentInteractor<P extends FragmentContract.Presenter> implements FragmentContract.Interactor<P> {
  private P mPresenter;
  private List<Disposable> mDisposables;

  public BaseFragmentInteractor(P presenter) {
    mPresenter = presenter;
    mDisposables = new ArrayList<>();
  }

  @Override
  public void addDisposable(Disposable disposable) {
    mDisposables.add(disposable);
  }

  @Override
  public void dispose() {
    for (Disposable disposable : mDisposables) {
      if (!disposable.isDisposed())
        disposable.dispose();
    }
    mDisposables.clear();
  }

  protected P getPresenter() {
    return mPresenter;
  }
}
