package self.yue.basejava.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dongc on 10/21/2017.
 */

public class JsonHelper {
  private static Gson sGson;

  private JsonHelper() {
  }

  public static Gson getGson() {
    if (sGson == null) {
      sGson = new Gson();
    }
    return sGson;
  }

  public static boolean isJson(String data) {
    try {
      new JSONObject(data);
    } catch (JSONException e) {
      try {
        new JSONArray(data);
      } catch (JSONException e1) {
        return false;
      }
    }
    return true;
  }
}
