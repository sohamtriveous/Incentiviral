package com.incentiviral.android;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Store {

    public static SharedPreferences getPrefs(final Context context) {
        if (RecorderApplication.getAppContext() != null) {
            return RecorderApplication.getAppContext().getSharedPreferences(
                    PREFERENCES_BASE, Context.MODE_PRIVATE);
        } else {
            return null;
        }
    }

    public static SharedPreferences.Editor getPrefEdit() {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().edit();
        } else {
            return null;
        }
    }

    // default getBoolean, defValue is false
    public static boolean getBoolean(final String key) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getBoolean(key, false);
        } else {
            return false;
        }
    }

    // defValue based pilymorphic getBoolean
    public static boolean getBoolean(final String key, boolean defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getBoolean(key, defValue);
        } else {
            return defValue;
        }
    }

    public static String getString(final String key) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getString(key, null);
        } else {
            return null;
        }
    }

    public static String getString(final String key, String defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getString(key, defValue);
        } else {
            return defValue;
        }
    }

    public static int getInt(final String key) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getInt(key, -1);
        } else {
            return -1;
        }
    }

    public static int getInt(final String key, int defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getPrefs().getInt(key, defValue);
        } else {
            return defValue;
        }
    }

    // 3. Default shared preferences (settings)

    // return default shared prefs
    public static SharedPreferences getDefPrefs() {
        if (RecorderApplication.getAppContext() != null) {
            return PreferenceManager
                    .getDefaultSharedPreferences(RecorderApplication
                            .getAppContext());
        } else {
            return null;
        }
    }

    // default getBoolean, defValue is false
    public static boolean getDefBoolean(final String key) {
        if (RecorderApplication.getAppContext() != null) {
            return getDefPrefs().getBoolean(key, false);
        } else {
            return false;
        }
    }

    // defValue based pilymorphic getBoolean
    public static boolean getDefBoolean(final String key, boolean defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getDefPrefs().getBoolean(key, defValue);
        } else {
            return defValue;
        }
    }

    public static String getDefString(final String key) {
        if (RecorderApplication.getAppContext() != null) {
            return getDefPrefs().getString(key, null);
        } else {
            return null;
        }
    }

    public static String getDefString(final String key, String defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getDefPrefs().getString(key, defValue);
        } else {
            return defValue;
        }
    }

    public static int getDefInt(final String key, int defValue) {
        if (RecorderApplication.getAppContext() != null) {
            return getDefPrefs().getInt(key, defValue);
        } else {
            return defValue;
        }
    }
}
