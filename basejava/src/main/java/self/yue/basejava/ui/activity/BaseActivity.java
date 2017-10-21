package self.yue.basejava.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import self.yue.basejava.utils.DialogUtils;
import self.yue.basejava.vipe.CommonView;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements CommonView {
  private Unbinder mUnbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());
    mUnbinder = ButterKnife.bind(this);
  }

  @Override
  protected void onDestroy() {
    mUnbinder.unbind();
    super.onDestroy();
  }

  @Override
  public void showMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showMessage(@StringRes int messageResId) {
    Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showLoadingDialog(String loadingMessage) {
    DialogUtils.showLoadingDialog(this, loadingMessage);
  }

  @Override
  public void dismissLoadingDialog() {
    DialogUtils.dismissLoadingDialog();
  }

  public void showKeyboard(EditText editText) {
    InputMethodManager inputMethodManager =
            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    inputMethodManager.toggleSoftInputFromWindow(
            editText.getApplicationWindowToken(),
            InputMethodManager.SHOW_FORCED, 0);
  }

  public void hideKeyboard() {
    getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
    );
  }

  protected abstract int getLayoutResId();
}
