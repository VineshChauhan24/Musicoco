package com.duan.musicoco.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

/**
 * Created by DuanJiaNing on 2017/6/2.
 */

public class AppPreference {

    public static final String APP_PREFERENCE = "app_preference";

    public static final String KEY_THEME = "key_theme";

    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    private Context context;

    public AppPreference(Context context) {
        this.context = context;
    }

    public void modifyTheme(Theme theme) {
        check();
        editor = preferences.edit();
        editor.putString(KEY_THEME, theme.name());
        editor.apply();
    }

    private void check() {
        if (preferences == null)
            preferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);

    }

    public Theme getTheme() {
        check();
        String pa = preferences.getString(KEY_THEME, Theme.DARKGOLD.name());
        return Theme.valueOf(pa);
    }

}
