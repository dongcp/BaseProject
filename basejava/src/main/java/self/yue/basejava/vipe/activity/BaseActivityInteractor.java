package self.yue.basejava.vipe.activity;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseActivityInteractor<P extends ActivityContract.Presenter>
        implements ActivityContract.Interactor<P> {
  private P mPresenter;

  public BaseActivityInteractor(P presenter) {
    mPresenter = presenter;
  }

  public P getPresenter() {
    return mPresenter;
  }
}
