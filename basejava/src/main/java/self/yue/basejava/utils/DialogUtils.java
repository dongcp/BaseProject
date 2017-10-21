package self.yue.basejava.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import self.yue.basejava.R;

/**
 * Created by dongc on 10/21/2017.
 */

public class DialogUtils {
  @LayoutRes
  private static int sLoadingDialogLayoutResId = R.layout.dialog_loading;

  private static Dialog sLoadingDialog;

  public static void setLoadingDialogLayoutResId(int loadingDialogLayoutResId) {
    sLoadingDialogLayoutResId = loadingDialogLayoutResId;
  }

  public static void showLoadingDialog(Context context, String loadingMessage) {
    if (sLoadingDialog == null) {
      sLoadingDialog = new Dialog(context);
      sLoadingDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
      sLoadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
      sLoadingDialog.setCancelable(false);

      View dialogView = LayoutInflater.from(context).inflate(sLoadingDialogLayoutResId, null);
      if (!TextUtils.isEmpty(loadingMessage)) {
        ((TextView) dialogView).setText(loadingMessage);
      }
      sLoadingDialog.setContentView(dialogView);
    }
    if (!sLoadingDialog.isShowing())
      sLoadingDialog.show();
  }

  public static void dismissLoadingDialog() {
    if (sLoadingDialog != null) {
      if (sLoadingDialog.isShowing())
        sLoadingDialog.dismiss();
      sLoadingDialog = null;
    }
  }
}
