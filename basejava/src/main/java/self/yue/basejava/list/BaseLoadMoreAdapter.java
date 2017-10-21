package self.yue.basejava.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import self.yue.basejava.R;

/**
 * Created by dongc on 10/21/2017.
 */

public abstract class BaseLoadMoreAdapter<E extends Item, VH extends BaseViewHolder<E>> extends BaseNormalAdapter<E, RecyclerView.ViewHolder> {
  public static final int VIEW_TYPE_LOAD_MORE = 772;

  private static final int DEFAULT_VISIBLE_THRESHOLD = 7;

  private RecyclerView mRecyclerView;
  private boolean mLoading;
  private int mVisibleThreshold;

  private OnLoadMoreListener mOnLoadMoreListener;

  public BaseLoadMoreAdapter(Context context, RecyclerView recyclerView) {
    super(context);
    mRecyclerView = recyclerView;
    mLoading = false;
    mVisibleThreshold = DEFAULT_VISIBLE_THRESHOLD;

    final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        final int totalItemCount = linearLayoutManager.getItemCount();
        final int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

        if (!mLoading && totalItemCount <= (lastVisibleItem + mVisibleThreshold)) {
          if (mOnLoadMoreListener != null) {
            showLoadMoreItem();
            mLoading = true;
            mOnLoadMoreListener.onLoadMore();
          }
        }
      }
    });
  }

  public void setVisibleThreshold(int visibleThreshold) {
    mVisibleThreshold = visibleThreshold;
  }

  public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
    mOnLoadMoreListener = onLoadMoreListener;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == VIEW_TYPE_LOAD_MORE)
      return new LoadMoreItemHolder(LayoutInflater.from(getContext())
              .inflate(getLoadMoreLayoutResId(), parent, false));
    return createNormalViewHolder(parent, viewType);
  }

  @Override
  public int getItemViewType(int position) {
    return getItem(position).getViewType();
  }

  public void hideLoadMoreItem() {
    mLoading = false;

    for (int i = getItems().size() - 1; i > 0; i--) {
      if (getItem(i).getViewType() == VIEW_TYPE_LOAD_MORE) {
        final int removePosition = i;
        getItems().remove(removePosition);
        mRecyclerView.post(new Runnable() {
          @Override
          public void run() {
            notifyItemRemoved(removePosition);
          }
        });
        break;
      }
    }
  }

  protected abstract VH createNormalViewHolder(ViewGroup parent, int viewType);

  protected int getLoadMoreLayoutResId() {
    return R.layout.item_load_more;
  }

  protected abstract E initLoadMoreItem();

  private void showLoadMoreItem() {
    getItems().add(initLoadMoreItem());
    mRecyclerView.post(new Runnable() {
      @Override
      public void run() {
        notifyItemInserted(getItemCount() - 1);
      }
    });
  }
}
