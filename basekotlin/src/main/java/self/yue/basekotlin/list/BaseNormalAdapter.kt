package self.yue.basekotlin.list

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Created by dongc on 10/20/2017.
 */
abstract class BaseNormalAdapter<E, VH : RecyclerView.ViewHolder>(context: Context) : RecyclerView.Adapter<VH>() {
  private val mContext = context
  val context
    get() = mContext

  private val mItems: MutableList<E> = ArrayList()

}