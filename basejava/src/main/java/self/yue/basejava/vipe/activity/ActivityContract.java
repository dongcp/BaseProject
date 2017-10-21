package self.yue.basejava.vipe.activity;

import self.yue.basejava.vipe.CommonView;

/**
 * Created by dongc on 10/21/2017.
 */

public interface ActivityContract {
  interface Interactor<P extends Presenter> {
  }

  interface View<P extends Presenter> extends CommonView {
  }

  interface Presenter<V extends View, I extends Interactor> {
    void attachView(V view);
  }
}
