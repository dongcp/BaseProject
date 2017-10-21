package self.yue.basejava.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import self.yue.basejava.vipe.activity.ActivityContract;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseVipeActivity<P extends ActivityContract.Presenter> extends BaseActivity
        implements ActivityContract.View {
  private P mPresenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mPresenter = initPresenter();
    mPresenter.attachView(this);
  }

  protected abstract P initPresenter();
}
