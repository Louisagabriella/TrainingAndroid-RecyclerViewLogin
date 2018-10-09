package id.co.asyst.gabriella.louisa.recyclerviewlogin.utility;

import android.content.Context;
import android.content.SharedPreferences;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.constant.Constant;

public class SessionUtility {

    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionUtility(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(Constant.KEY_FILE, 0);
        editor = sharedPreferences.edit();
    }

    public void saveLogin(String name, String password) {
        editor.putString(Constant.KEY_NAME, name);
        editor.putString(Constant.KEY_PASSWORD, password);
        editor.commit();
    }

    public String loadName() {
        String name = sharedPreferences.getString(Constant.KEY_NAME, "");
        return name;
    }

    public String loadPassword() {
        String password = sharedPreferences.getString(Constant.KEY_PASSWORD, "");
        return password;
    }
}
