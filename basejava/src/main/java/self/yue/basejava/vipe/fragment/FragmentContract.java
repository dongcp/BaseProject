package self.yue.basejava.vipe.fragment;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.Disposable;
import self.yue.basejava.vipe.CommonView;

/**
 * Created by dongc on 10/21/2017.
 */

public interface FragmentContract {
  interface Interactor<P extends Presenter> {
    void addDisposable(Disposable disposable);

    void dispose();
  }

  interface View<P extends Presenter> extends CommonView {
    void setPresenter(P presenter);

    P getPresenter();
  }

  interface Presenter<V extends View, I extends Interactor> {
    Fragment getFragment();

    void dispose();
  }
}
