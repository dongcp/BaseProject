package self.yue.basejava.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

/**
 * Created by dongc on 10/21/2017.
 */

public class RealmHelper {
  public static void setupRealm(Context context, String databaseName, int schemaVersion) {
    Realm.init(context);
    RealmConfiguration config = new RealmConfiguration.Builder()
            .name(databaseName)
            .schemaVersion(schemaVersion)
            .build();
    Realm.setDefaultConfiguration(config);
  }

  public static <E extends RealmObject> void removeItemById(final Class<E> table, final String key, final long value) {
    Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(@NonNull Realm realm) {
        E foundItem = realm.where(table).equalTo(key, value).findFirst();
        if (foundItem != null)
          foundItem.deleteFromRealm();
      }
    });
  }
}
