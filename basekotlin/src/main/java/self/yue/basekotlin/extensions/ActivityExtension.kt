package self.yue.basekotlin.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Created by dongc on 10/20/2017.
 */

fun Activity.hideKeyboard(): Boolean {
  val view = currentFocus
  view?.let {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    return inputMethodManager.hideSoftInputFromWindow(view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS)
  }
  return false
}