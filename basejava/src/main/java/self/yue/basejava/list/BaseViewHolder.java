package self.yue.basejava.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by dongc on 10/20/2017.
 */

public abstract class BaseViewHolder<E extends Item> extends RecyclerView.ViewHolder {
  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public abstract void bindView(E item, int position);
}
