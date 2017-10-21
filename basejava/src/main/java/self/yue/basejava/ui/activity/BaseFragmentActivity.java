package self.yue.basejava.ui.activity;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import self.yue.basejava.R;
import self.yue.basejava.vipe.CommonView;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseFragmentActivity extends BaseActivity implements CommonView {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getSupportFragmentManager().beginTransaction().add(getFragmentContainerResId(), getFirstFragment()).commit();
  }

  @Override
  public void onBackPressed() {
    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

    } else
      super.onBackPressed();
  }

  protected abstract int getFragmentContainerResId();

  protected abstract Fragment getFirstFragment();

  public void replace(Fragment fragment, String tag) {
    replaceWithCustomAnimation(fragment, tag,
            R.anim.slide_right_in, R.anim.slide_left_out,
            R.anim.slide_left_in, R.anim.slide_right_out);
  }

  public void replaceWithCustomAnimation(Fragment fragment, String tag,
                                         @AnimRes int enter, @AnimRes int exit,
                                         @AnimRes int popEnter, @AnimRes int popExit) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager()
            .beginTransaction()
            .setCustomAnimations(enter, exit, popEnter, popExit)
            .replace(getFragmentContainerResId(), fragment);

    if (!TextUtils.isEmpty(tag))
      fragmentTransaction.addToBackStack(tag);
    fragmentTransaction.commit();
  }
}
