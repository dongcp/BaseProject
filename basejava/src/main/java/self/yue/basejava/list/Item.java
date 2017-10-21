package self.yue.basejava.list;

import io.realm.RealmModel;

/**
 * Created by dongc on 10/20/2017.
 */

public interface Item extends RealmModel {

  void setViewType(int viewType);

  int getViewType();
}
