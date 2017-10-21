package self.yue.basejava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseParentFragment extends BaseFragment {
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getFragmentManager().beginTransaction()
            .add(getFragmentContainerResId(), getFirstFragment())
            .commit();
  }

  protected abstract int getFragmentContainerResId();

  protected abstract Fragment getFirstFragment();
}
