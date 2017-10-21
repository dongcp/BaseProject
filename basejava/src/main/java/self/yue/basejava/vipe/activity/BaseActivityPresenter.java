package self.yue.basejava.vipe.activity;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseActivityPresenter<V extends ActivityContract.View, I extends ActivityContract.Interactor>
        implements ActivityContract.Presenter<V, I> {
  private V mView;
  private I mInteractor;

  public BaseActivityPresenter() {
    mInteractor = initInteractor();
  }

  @Override
  public void attachView(V view) {
    mView = view;
  }

  public V getView() {
    return mView;
  }

  public I getInteractor() {
    return mInteractor;
  }

  protected abstract I initInteractor();
}
