package self.yue.basekotlin.vipe

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by dongc on 10/20/2017.
 */
interface CommonView {
  fun showMessage(message: String)

  fun showMessage(@StringRes messageResId: Int)

  fun showLoadingProgress(context: Context)

  fun dismissLoadingProgress()
}