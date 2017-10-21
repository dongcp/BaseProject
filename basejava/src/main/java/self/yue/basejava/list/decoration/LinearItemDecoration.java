package self.yue.basejava.list.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import self.yue.basejava.R;

/**
 * Created by dongc on 10/20/2017.
 */

public class LinearItemDecoration extends RecyclerView.ItemDecoration {
  private int mLeft;
  private int mTop;
  private int mRight;
  private int mBottom;

  public LinearItemDecoration(Context context) {
    mLeft = mTop = mRight = mBottom =
            context.getResources().getDimensionPixelSize(R.dimen.default_recycler_item_space);
  }

  public LinearItemDecoration(int space) {
    mLeft = mTop = mRight = mBottom = space;
  }

  public LinearItemDecoration(int left, int top, int right, int bottom) {
    mLeft = left;
    mTop = top;
    mRight = right;
    mBottom = bottom;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    int position = parent.getChildLayoutPosition(view);
    outRect.top = position == 0 ? 0 : mTop;
    outRect.left = mLeft;
    outRect.right = mRight;
    outRect.bottom = mBottom;
  }
}
