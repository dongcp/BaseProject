package self.yue.basejava.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import io.realm.RealmList;

/**
 * Created by dongc on 10/20/2017.
 */

public abstract class BaseNormalAdapter<E extends Item, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {
  private Context mContext;
  private RealmList<E> mItems;

  public BaseNormalAdapter(Context context) {
    mContext = context;
    mItems = new RealmList<>();
  }

  @Override
  public int getItemCount() {
    return mItems.size();
  }

  public void addItem(E item) {
    mItems.add(item);
    notifyItemInserted(mItems.size() - 1);
  }

  public void addItems(RealmList<E> items) {
    int previousSize = mItems.size();
    mItems.addAll(items);
    notifyItemRangeInserted(previousSize, items.size());
  }

  public void refreshList(RealmList<E> items) {
    mItems = items;
    notifyDataSetChanged();
  }

  public RealmList<E> getItems() {
    return mItems;
  }

  public E getItem(int position) {
    return mItems.get(position);
  }

  protected Context getContext() {
    return mContext;
  }
}
