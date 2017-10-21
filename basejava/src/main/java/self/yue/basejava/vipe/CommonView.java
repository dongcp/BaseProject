package self.yue.basejava.vipe;

import android.support.annotation.StringRes;

/**
 * Created by dongc on 10/21/2017.
 */

public interface CommonView {
  void showMessage(String message);

  void showMessage(@StringRes int messageResId);

  void showLoadingDialog(String loadingMessage);

  void dismissLoadingDialog();
}
